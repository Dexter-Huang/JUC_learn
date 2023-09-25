package Volatile;


public class VolatileVisibilityTest {
    public static volatile boolean flag = false;

    public static void changeCondition(){
        flag = true;
    }

    public static  void main(String[] args) throws InterruptedException {
        System.out.println("working and waiting for change...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag){
                    System.out.println("flag: "+flag);
                }
            }
        }).start();

//        Thread.sleep(200);

        new Thread(new Runnable() {
            @Override
            public void run() {
                changeCondition();
                System.out.println("condition has changed.");
            }
        }).start();

        Thread.sleep(200);
        System.out.println("work done.");

    }

}

