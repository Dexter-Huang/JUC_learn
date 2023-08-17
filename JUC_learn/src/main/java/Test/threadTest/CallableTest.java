package Test.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		for (int i = 0; i < 10; i++) {
			FutureTask<Integer> futureTask = new FutureTask<>(new MyCallableTest());
			new Thread(futureTask).start();
			System.out.println(futureTask.get());
		}
	}
}

class MyCallableTest implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() +"\t 创建线程");
		return 1;
	}
}

