package AccJUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class PrintABC_Semaphore {
    private static int state = 0;

    // 三个信号量对象，分别表示A、B、C三个线程的初始许可数
    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);

    public static void run(int targetState, String name, Semaphore cur, Semaphore next) {
        for (int i = 0; i < 10; i++) {
            try {
//                System.out.println("============");
//                System.out.println(cur.availablePermits());
                cur.acquire();
//                System.out.println(cur.availablePermits());
                System.out.println(targetState+":"+name);
//                System.out.println(next.availablePermits());
                next.release();
//                System.out.println(next.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            run(0, "A", A, B);
        });
        executorService.execute(() -> {
            run(1, "B", B, C);
        });
        executorService.execute(() -> {
            run(2, "C", C, A);
        });
        executorService.shutdown();
    }
}
