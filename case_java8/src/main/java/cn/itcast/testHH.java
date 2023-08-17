package cn.itcast;

import static cn.itcast.n2.util.Sleeper.sleep;

public class testHH {
    static int x;
    public static void main(String[] args)
    {
        Thread t2 = new Thread(()->
        {
            while(true)
            {
                if(Thread.currentThread().isInterrupted())
                {
                    System.out.println("t2:"+x);
                    break;
                }
            }
        }, "t2");
        t2.start();
        new Thread(()-> {
            sleep(1);
            x = 10;
            t2.interrupt();
        }, "t1").start();
        while(!t2.isInterrupted())
        {
            System.out.println("=========");
            Thread.yield();
        }
        System.out.println("end:"+x);
    }
}
