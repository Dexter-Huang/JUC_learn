package AccJUC.csdn;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    class Hhhh {
        int a;
        Double b;

        public Hhhh(int a, Double b) {
            this.a = a;
            this.b = b;
        }
    }

    class MyCall implements Callable<Hhhh> {

        @Override
        public Hhhh call() throws Exception {
            Thread.sleep(5000);
            return new Hhhh(1, 2.0);
        }
    }

    public static void main(String[] args) {
        FutureTask<Hhhh> futureTask = new FutureTask<>(new CallableTest().new MyCall());
        new Thread(futureTask).start();
        try {
            Hhhh hhhh = futureTask.get();
            System.out.println(hhhh.a);
            System.out.println(hhhh.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
