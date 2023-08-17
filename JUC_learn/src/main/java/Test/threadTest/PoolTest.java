package Test.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public
class PoolTest {
	public static void main(String[] args) {
		Anonymity();
	}

	// 匿名创建
	public static void Anonymity(){
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() +"\t线程创建");
				}
			});
		}
	}

	// 非匿名创建
	public static void unAnonymity(){
		ExecutorService es = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			ThreadPool tp = new ThreadPool();
			es.submit(tp);
		}
		// 关闭线程池  如果不关闭，则永远停滞在这里
		es.shutdown();
	}
}

class ThreadPool implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +"\t线程创建");
	}
}
