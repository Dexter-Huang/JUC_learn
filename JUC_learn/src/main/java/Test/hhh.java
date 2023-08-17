package Test;

public class hhh {
	public static void main(String[] args) {
		System.out.println("opop");
	}
}
interface InterfaceA {

	public abstract void methodA();

	public abstract void methodCommon();

	public default void methodDefault() {
		System.out.println("A");
	}

}


interface InterfaceB {

	public abstract void methodA();

	public abstract void methodCommon();

	public default void methodDefault() {
		System.out.println("A");
	}

}


// 多继承接口
interface InterfaceC extends InterfaceA, InterfaceB {

	public abstract void method();
	

	@Override
	default void methodDefault() {

	}

	//多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写
//	@Override
//	public default void methodDefault() {
//
//	}
}


