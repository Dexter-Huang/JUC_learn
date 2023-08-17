package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;

@Slf4j(topic = "c.Test17")
public class Test17 {

    static int count=0;
    static Object lock = new Object();
    static Object lock2 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
                synchronized (lock){
                    count++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.decrement();
                    count--;

            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}", room.getCounter());
        log.debug("{}", count);
    }
}

class Room {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }
    //读不加锁就会脏读
    //比如先做了count+1 但是还没aload进去 发生了上下文切换
    //这时切换到get这里 因为没加锁它不会阻塞等待而是直接获取count 那就拿到了中间值
    //两个线程都读不用加锁，如果俩线程只要有一个写那么读也得加锁
    public synchronized int getCounter() {
        return counter;
    }
}
