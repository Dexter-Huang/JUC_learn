package cn.itcast.amine;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@FunctionalInterface // 拒绝策略
interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}

@Slf4j(topic = "c.TestPool")
public class TestPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(1,1000,TimeUnit.MILLISECONDS,1,
                (queue, task)->{
                    // 1. 死等
//            queue.put(task);
                    // 2) 带超时等待
//            queue.offer(task, 1500, TimeUnit.MILLISECONDS);
                    // 3) 让调用者放弃任务执行
//            log.debug("放弃{}", task);
                    // 4) 让调用者抛出异常
            throw new RuntimeException("任务执行失败 " + task);
                    // 5) 让调用者自己执行任务
//                    task.run();
        });

        for(int i=0;i<5;i++){ // 任务太多阻塞队列放不下，拒绝放不下的任务
            int j = i;
            threadPool.execute(()->{
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.debug("完成任务{}",j);
            });
        }
    }


}
@Slf4j(topic = "c.THreadPool")
class ThreadPool{
    // 任务队列
    // 任务可以抽象为Runnable
    private BlockingQueue<Runnable> taskQueue;

    // 线程集合 === 线程池
    private HashSet<Worker> workers = new HashSet(); // workers为共享资源，需要线程安全

    //核心线程数
    private int coreSize;

    // 获取任务的超时时间 ， 一旦过了超时时间还没有任务，就可以结束该线程
    private long timeout;

    private RejectPolicy<Runnable> rejectPolicy;

    public void execute(Runnable task){
        synchronized (workers){ // 保护的是workers的线程安全则用workers
            //当目前工作中的线程数少于当前核心线程总数，则直接交给worker处理
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                log.debug("新增 worker{},{}",worker,task);
                //将worker加入到workers
                workers.add(worker);
                //启动线程
                worker.start();
            }
            //当目前工作中的线程数多于当前核心线程总数，则将多出的任务直接插入阻塞队列
            else{ // 带拒绝策略的put 操作
                taskQueue.tryPut(rejectPolicy, task);
            }
        }


    }

    public ThreadPool(int coreSize, long timeout, TimeUnit unit,int capacity,RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.unit = unit;
        this.taskQueue = new BlockingQueue<>(capacity);
        this.rejectPolicy = rejectPolicy;
    }

    private TimeUnit unit;


    // Worker 封装 Thread类
    class Worker extends Thread{
        private Runnable task;
        public Worker(Runnable task) {
            this.task=task;
        }

        @Override
        public void run(){
            // 执行任务
            // 当构造器的task 不为空，执行该task
            // 当执行完构造器的内容时，还需要看看阻塞队列里面是否有多余的任务需要执行
            while (task!=null||(task=taskQueue.poll(timeout,unit))!=null){
                try {
                    log.debug("正在执行task{}",task);
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    task=null;
                }
            }

            // 当真的没有任务做时，就将该worker从线程池里面移出
            // 注意workers为线程共享变量
            synchronized (workers){
                log.debug("worker 被移除{}",this);
                workers.remove(this);
            }

        }

    }
}
@Slf4j(topic = "c.BlockingQueue")
class BlockingQueue<T>{
    private Deque<T> queue = new ArrayDeque<>();
    private ReentrantLock lock = new ReentrantLock();
    // 生产者条件变量
    private Condition fullWaitSet = lock.newCondition();
    // 消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // 带超时的阻塞获取
    public T poll(long timeout,TimeUnit unit){
        lock.lock();
        try{
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()){
                try {
                    if(nanos<=0)
                        return null;
                    nanos=emptyWaitSet.awaitNanos(nanos);//返回剩余时间
                    // 没等够就被唤醒，但没抢到任务，下次循环还得等这么多时间，不合理
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    // 任务获取
    public T take(){
        lock.lock();
        try{
            while (queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }

    }

    // 带超时时间的任务添加 -- 超时放弃策略
    // 添加任务超时了就返回false，添加任务没超时就返回true
    public boolean offer(T task, long timeout, TimeUnit unit){// 如果不加超时时间，队列满了的话，会一直死等
        lock.lock();
        try {

            long nanos = unit.toNanos(timeout);
            while (queue.size()==capacity){
                try {
                    log.debug("等待加入任务队列的task{} 。。。",task);
                    if(nanos<=0){
                        log.debug("加入任务队列的task超时了！！！",task);
                        return false;
                    }
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.debug("加入任务队列{}",task);
            queue.addLast(task);
            emptyWaitSet.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    // 任务添加 --- 死等策略
    public void put(T task){// 如果不加超时时间，队列满了的话，会一直等待
        lock.lock();
        try {
            while (queue.size()==capacity){
                try {
                    log.debug("等待加入任务队列的task{}",task);
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.debug("加入任务队列{}",task);
            queue.addLast(task);
            emptyWaitSet.signal();
        }finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            // 判断队列是否满
            if(queue.size() == capacity) {
                rejectPolicy.reject(this, task);
            } else {  // 有空闲
                log.debug("加入任务队列 {}", task);
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    // 获取队列大小
    public int size(){
        lock.lock();
        try {
            return queue.size();
        }finally {
            lock.unlock();
        }

    }
}
