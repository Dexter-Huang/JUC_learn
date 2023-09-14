package Lock;

import jdk.internal.misc.Unsafe;

import java.util.concurrent.locks.LockSupport;

public class MiniLock implements Lock{
    /**
     * 锁实质上是一个标志位，
     * 标志位!=0-->锁被占用，
     * 标志位==0-->锁空闲
     */
    private volatile int state;

    /**
     * 独占模式
     * 在同一时刻，只有一个线程能够持有锁，其他线程没获取到锁的线程会被阻塞
     * 该字段表示当前独占锁对应的线程
     */
    private Thread exclusiveOwnerThread;
    //head节点对应当前持有锁的线程
    private Node head,tail;

    // 等待/唤醒队列 所用到的节点Node
    static final class Node{
        Node prev;
        Node next;
        /**
         * 当前node节点封装的线程
         */
        Thread thread;

        public Node(Thread thread){
            this.thread = thread;
        }
        public Node(){
        }
    }

    @Override
    public void unlock() {
        release(1);
    }

    /**
     * 释放锁
     */
    private void release(int arg) {
        if (tryRelease(arg)) {
            // 释放锁成功
            // 唤醒后继节点
            if (head.next != null) {
                unparkSuccessor(head);
            }
        }
    }

    private void unparkSuccessor(Node node){
        // 获取当前节点的后继节点
        Node s = node.next;
        if(s == null || s.thread == null){
            return;
        }
        // 唤醒后继节点
        LockSupport.unpark(s.thread);
    }

    /**
     * true -- 完全释放锁了
     * false -- 锁还没有完全释放
     */
    private boolean tryRelease(int arg){
        int c = state - arg;
        if(Thread.currentThread() != exclusiveOwnerThread){//理论上都是自己释放自己的锁
            throw new RuntimeException();
        }
        // 执行到这里，没有并发问题
        if(c == 0){
            // 释放锁成功
            exclusiveOwnerThread = null;
            state = 0;
            return true;
        }
        state = c;
        return false;
    }


    /**
     * 目的：获取锁，假设当前锁被占用了，会阻塞调用者的线程，直到抢占到锁为止
     * 模拟公平锁：先来后到
     * lock过程：
     * 情景一：线程进来之后 state == 0，直接抢锁
     * 情景二：线程进来之后 state > 0，加入锁的阻塞队列，等待被唤醒
     */
    @Override
    public void lock() {
        acquire(1);
    }



    /**
     * 竞争资源来获取锁
     * 1.尝试抢占锁，成功抢占到锁，就返回
     * 2.抢占锁失败的话，将线程阻塞，放入阻塞队列
     */
    private void acquire(int arg){
        if(!tryAcquire(arg)){ // 抢锁失败
            // 1.抢锁失败的话，把自己打包成Node节点，加入到阻塞队列中
            Node node = addWaiter();
            // 2.阻塞自己
            accquireQueued(node,arg);
        }
    }


    private void accquireQueued(Node node, int arg){
        // 只有当前节点是head.next节点，才会跳出自旋
        for(;;){
            // 什么时候会被唤醒获取锁
            // 1.当前节点是head.next节点（遵循先来后到）
            // 2.head节点对应现成 就是当前持有锁的线程
            Node pred = node.prev;
            if(pred == head/*是否有资格来抢锁*/&&tryAcquire(arg)){
                // 抢占锁成功
                // 1.抢占成功后，将自己设为head节点，旧head节点出队，自己执行相关业务代码
                this.head = node;
                pred.next = null;
                return;
            }
            // 抢锁失败
            LockSupport.park();
        }
    }

    /**
     * 尝试抢占锁失败之后我们需要做什么？
     * 1. 当前线程将自己封装成Node节点，加入到阻塞队列中
     * 2. 将当前线程park住，阻塞自己
     * 。。。
     * park之后唤醒线程
     * 唤醒线程后每个线程需要做什么？
     * 1. 先检测自己是不是head.next节点，如果是的话，尝试抢占锁
     * 2.抢占
     *    成功：1.抢占成功后，将自己设为head节点，旧head节点出队，自己执行相关业务代码
     *    失败：2.抢占失败，继续park住，阻塞自己，等待下一轮唤醒
     */




    /**
     * 将当前线程加入到阻塞队列中，并返回当前线程的节点Node
     * addWaiter 调用链 lock-> aquaire->tryAcquire->addWaiter 保证入队成功
     */
    private Node addWaiter(){
        Node newNode = new Node(Thread.currentThread());
        // 如何进入阻塞队列？
        // 1.先找到未来的前驱节点，找到前驱节点之后，将自己设置为前驱节点的后继节点
        // 2.cas操作，将自己设置为tail节点
        // 3.pre.next = newNode;
        Node pre  = tail;
        if(pre != null){
            newNode.prev = pre;
            if(compareAndSetTail(pre,newNode)){
                pre.next = newNode;
                return newNode;
            }
        }
        // 失败情况：
        // 1. tail == null
        // 2. cas操作失败

        //自旋操作
        enq(newNode);
        return newNode;
    }

    /**
     * 自旋入队，只有成功入队才会返回
     */
    private void enq(Node node){
        for(;;){
            // 队列为空，并且第一个抢占锁的线程，当前持有锁的线程，并没有入队，没有设置任何的Node节点
            // 作为后驱节点，需要为当前线程创建一个Node节点，然后设置为head节点，保证 【head节点任何时候都是占用锁的线程】
            if(tail == null) {
                if (compareAndSetHead(new Node())) {
                    tail = head;
                    // 这里不返回
                }
            } else{
                // 说明队列中已经有线程在排队了，当前线程只需要入队即可
                // 1.找到队列中的最后一个节点
                // 2.将当前线程封装成Node节点，设置为最后一个节点的后继节点
                // 3.将当前线程设置为tail节点
                Node pred = tail;
                node.prev = pred;
                if(compareAndSetTail(pred,node)){
                    pred.next = node;
                    return;
                }
            }
        }
    }

    /**
     * 尝试获取锁，不会阻塞队列
     * true -> 抢占成功
     * false -> 抢占失败
     */
    private boolean tryAcquire(int arg) {
        if (state == 0) { // 说明锁空闲
            /**
             *  当前state == 0 的话，能否直接抢占锁？
             *  不行，公平锁，需要先来后到
             *         条件一：当前锁中阻塞队列中没有线程等待
             *         条件二：CAS方式去设置state的值，避免多线程并发下同时进行state=1的行为
             */
              // 抢占成功
              if (!hasQueuedPredecessor() && compareAndSetState(0, arg)) {// 说明当前线程是第一个抢占锁的线程
                  //抢占锁成功
                  exclusiveOwnerThread = Thread.currentThread();
                  return true;
              }

        } else if (Thread.currentThread().equals(exclusiveOwnerThread)) { // 当前锁被占用了且 当前线程就是占用线程
            //说明锁 被重新进入了 --> 可重入锁
            // 注意：当前不存在并发问题，因为当前线程就是占用锁的线程，条件限制了只有一个线程(即当前线程)能够进入到这里
            state += arg;
            return true;
        }
        return false;
    }

    /**
     * 判断阻塞队列里面有没有等待的线程
     *
     * hasQueuedPredecessor 调用链 lock-> aquaire->tryAcquire->hasQueuedPredecessor
     *
     * 什么时候返回false？
     * 1.队列为空
     * 2.抢锁的线程为head.next线程的时候（head.next是唯一在队列中拥有抢锁资格的线程）
     */
    private boolean hasQueuedPredecessor() {
        Node h = head;
        Node t = tail;
        Node s;
//        return h != t && ((s = h.next) == null || s.thread != Thread.currentThread());
//        return h != t && ((s = h.next) != null) && (s.thread == Thread.currentThread());
        if(h == t){ // 说明head、tail都为空 或者 head、tail都不为空，但是只有一个节点
            return false;
        } else if((s = h.next) == null){ // 说明head、tail都不为空，且有多个节点，但是head.next为空
            return false;
        } else if(s.thread == Thread.currentThread()){ // 说明head、tail都不为空，且有多个节点，且head.next不为空，
                                                        // 但是head.next.thread == Thread.currentThread()
            return false;
        } else {
            return true;
        }
    }

    protected final boolean compareAndSetState(int expect, int update) {
        return true;
    }

    protected final boolean compareAndSetHead(Node update) {
        return true;
    }

    protected final boolean compareAndSetTail(Node expect, Node update) {
        return true;
    }
}
