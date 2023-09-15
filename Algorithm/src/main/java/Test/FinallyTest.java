package Test;

public class FinallyTest {
	public static void main(String[] args) {
		try{
			System.out.println("OOOOO");
			return;
		}
		finally {
			System.out.println("finally");
		}
	}
}
