package AccJUC.csdn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cycli = new CyclicBarrier(10);

        for (int i = 0; i < 9; i++) {
            new Thread(new BarrierThread("张" + i, cycli)).start();
        }

        Thread.sleep(8000);
        new Thread(new BarrierThread("张" + 10, cycli)).start();

        Thread.sleep(5000);
    }

}

class BarrierThread implements Runnable{

    private String  name;
    private CyclicBarrier cycli;

    public BarrierThread(String name, CyclicBarrier cycli) {
        super();
        this.name = name;
        this.cycli = cycli;
    }

    @Override
    public void run() {
        System.out.println(name + " 准备就绪");
        try {
            cycli.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 开始执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CyclicBarrier getCycli() {
        return cycli;
    }

    public void setCycli(CyclicBarrier cycli) {
        this.cycli = cycli;
    }
}

