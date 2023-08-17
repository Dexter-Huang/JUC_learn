package AccJUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintABC_Synchronized {

    private static int state = 0;
    private static final Object lock = new Object();

    public static void run(int targetState, String name) {
        for (int i = 0; i < 10; i++) {
            // 为什么不能是this
            synchronized (lock) {
                while (state % 3 != targetState) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.println(targetState+":"+name);
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {

//        Thread threadA = new Thread(() -> {
//            run(0, "A");
//        });
//        Thread threadB = new Thread(() -> {
//            run(1, "B");
//        });
//        Thread threadC = new Thread(() -> {
//            run(2, "C");
//        });
//
//        threadA.start();
//        threadB.start();
//        threadC.start();

//         线程池创建三个线程
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            run(0, "A");
        });
        executorService.execute(() -> {
            run(1, "B");
        });
        executorService.execute(() -> {
            run(2, "C");
        });
        executorService.shutdown();

    }
}
