package Test.threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class LamdaTest {


	private static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					//每个线程让count自增100次
					for (int i = 0; i < 100; i++) {
						count.incrementAndGet();
					}
				}
			}).start();
		}

		try{
			Thread.sleep(3000);
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(count);
	}
}
