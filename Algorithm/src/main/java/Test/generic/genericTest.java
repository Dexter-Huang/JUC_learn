package Test.generic;

class Fruit {}

class Apple extends Fruit {}

class Plate<T>{

	private T item;

	public Plate(T t){item=t;}

	public void set(T t){item=t;}

	public T get(){return item;}

}

public class genericTest {
	public static void main(String[] args) {

	}
}
