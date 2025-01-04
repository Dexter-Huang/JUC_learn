package AccJUC.csdn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class TestQueeThread_2 {
    static Semaphore semaphore = new Semaphore(20);
    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
        BlockingQueue<String> myQueue = new ArrayBlockingQueue<String>(1);

        for (int i = 0; i < 120; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        String log = myQueue.take();
                        System.out.println(Thread.currentThread().getName() + ":" + doSome(log));
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 100; i++) { // 这行代码不能改动
            String input = i + "";
            myQueue.put(input);
        }

        Thread.sleep(10000);
        System.out.println("又开始了");
        for (int i = 0; i < 20; i++) { // 这行代码不能改动
            String input = i + "";
            myQueue.put(input);
        }
    }

    public static String doSome(String input) {
        String output = null;
        try {
            Thread.sleep(1000);
            output = input + ":" + (System.currentTimeMillis() / 1000);
            return output;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
