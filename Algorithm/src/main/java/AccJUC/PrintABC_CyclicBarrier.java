package AccJUC;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

public class PrintABC_CyclicBarrier {
    // 共享变量，表示当前应该打印哪个字母
    private static int state = 0;

    // 参与线程数量
    private static int threadNum = 3;
    // 循环屏障，指定三个线程为屏障点，以及一个打印字母的屏障动作
    private static final CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
        @Override
        public void run() {
            // 根据state的值判断应该打印哪个字母
            switch (state) {
                case 0:
                    System.out.println(state+":A");
                    break;
                case 1:
                    System.out.println(state+":B");
                    break;
                case 2:
                    System.out.println(state+":C");
                    break;
            }
            // 修改状态
            state = (state + 1) % 3;
        }
    });

    public static void run(int targetState, String name) {
        try {
            for (int i = 0; i < threadNum*10; i++) {
                // 判断是否轮到当前线程打印
//                System.out.println(targetState+":"+name);
                // 等待屏障开放
                barrier.await();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(3);
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
