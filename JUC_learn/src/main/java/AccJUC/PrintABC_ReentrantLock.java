package AccJUC;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC_ReentrantLock {
    private static int state = 0;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    public static void run(int targetState, String name, Condition cur, Condition next) {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    cur.await();
                }
                state++;
                System.out.println(targetState+":"+name);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10,10,60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        executorService.submit(() -> {
            run(0, "A", conditionA, conditionB);
        });
        executorService.submit(() -> {
            run(1, "B", conditionB, conditionC);
        });
        executorService.submit(() -> {
            run(2, "C", conditionC, conditionA);
        });
        executorService.shutdown();
    }
}
