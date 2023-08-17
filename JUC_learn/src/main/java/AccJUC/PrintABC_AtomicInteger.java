package AccJUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintABC_AtomicInteger {
    // 共享变量，表示当前应该打印哪个字母
    private static AtomicInteger state = new AtomicInteger(0);

    public static void run(int targetState, String name) {
        for (int i = 0; i < 10; ) {
            if(state.get() % 3 == targetState) {
                System.out.println(targetState+":"+name);
                state.compareAndSet(state.get(), state.get()+1);
                i++;
            }
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
