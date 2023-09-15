package Test;

import java.util.LinkedList;

public class TestFrames {
	public static void main(String[] args) {
		LinkedList<String> sites = new LinkedList<String>();
		sites.add("Google");
		sites.add("Runoob");
		sites.add("Taobao");
		// 使用 addFirst() 在头部添加元素
		sites.addFirst("Wiki");
		System.out.println(sites);

		if(sites.contains("Runoob"))
			System.out.println(true);
	}

	public static void method1(int x){
		new Thread(()->{
			System.out.println("11");
			System.out.println("11");
			System.out.println("11");
			System.out.println("11");
			System.out.println("11");
			System.out.println("11");
			System.out.println("11");
			System.out.println("11");
			System.out.println("11");
		}).start();
	}

	public static void method2(){
		new Thread(()->{
			System.out.println("22");
			System.out.println("22");
			System.out.println("22");
			System.out.println("22");
			System.out.println("22");
			System.out.println("22");
			System.out.println("22");
		}).start();
	}
}
