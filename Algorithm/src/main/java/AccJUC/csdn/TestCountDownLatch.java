package AccJUC.csdn;

// 用法比较简单，直接上代码即可
// 1.CountDownLatch的同一对象传递
// 2.构造参数的默认值需要指定
// 3.线程完成的countDown()->会使默认值减一
// 4.主线程awiw()等待，所有线程都countDown之后，主线程执行
// 应用场景：比如五个子线程文件输出导出数据，主线程等所有子线程都完成之后开始压缩操作，上传文件

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {

    /***
     * 关键点:面向对象的方式->参数传递，把CountDownLatch进行传递，使其共用同一个参数
     * @param args
     */
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService executorService = Executors.newCachedThreadPool();
        MyWoker m1 = new MyWoker("work1", latch);
        MyWoker m2 = new MyWoker("work2", latch);
        MyWoker m3 = new MyWoker("work3", latch);
        MyWoker m4 = new MyWoker("work4", latch);
        MyWoker m5 = new MyWoker("work5", latch);
        Boss boss = new Boss("boos", latch);
        executorService.submit(m1);
        executorService.submit(m2);
        executorService.submit(m3);
        executorService.submit(m4);
        executorService.submit(m5);
        executorService.submit(boss);
        // 打印返回值
        System.out.println("返回值：" + m1.getName());

        executorService.shutdown();
    }
}

class MyWoker implements Callable<String> {

    private String name;
    private CountDownLatch latch;

    public MyWoker (String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        System.out.println(name + " 工人开始工作");
        int time = (int)(Math.random() * 100) * 50;
        Thread.sleep(time);
        System.out.println(name + " 工人已经完成任务!");
        latch.countDown();
        return "successful";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
}

class Boss implements Callable<String> {

    private String name;
    private CountDownLatch latch;

    public Boss (String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        System.out.println("老板准备就绪，等工人都完成了就来视察~");
        latch.await();
        System.out.println("老板来了，快跑啊~");
        return "successful";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
}
