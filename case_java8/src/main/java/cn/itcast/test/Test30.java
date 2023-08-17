package cn.itcast.test;

import sun.rmi.runtime.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test30 {
    public static void main(String[] args) throws InterruptedException {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        Thread thread_a_b = new Thread(() -> {
            awaitSignal.print("a", a, b);
        }, "a-b");
        Thread thread_b_c = new Thread(() -> {
            awaitSignal.print("b", b, c);
        }, "b-c");
        Thread thread_c_a = new Thread(() -> {
            awaitSignal.print("c", c, a);
        }, "c-a");


        thread_a_b.start();
        thread_b_c.start();
        thread_c_a.start();

        Thread.sleep(1000);
        awaitSignal.lock();
        try {
            System.out.println("开始...");
            a.signal();
        } finally {
            awaitSignal.unlock();
        }

    }
}

class AwaitSignal extends ReentrantLock{
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }
    //            参数1 打印内容， 参数2 进入哪一间休息室, 参数3 下一间休息室
    public void print(String str, Condition current, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                current.await();
                System.out.print(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}
