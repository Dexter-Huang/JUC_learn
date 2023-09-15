package Test.threadTest;

class ThreadTest {

	public static void main(String[] args) {
		noAnonymity();
	}

	//	匿名创建多线程
	public static void anonymity(){
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName() + "\t 创建线程");
			}).start();
		}
	}
	// 非匿名创建多线程
	public static void noAnonymity(){
		for (int i = 0; i < 10; i++) {
			new MyThread().start();
		}
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "\t 创建线程");
	}
}
