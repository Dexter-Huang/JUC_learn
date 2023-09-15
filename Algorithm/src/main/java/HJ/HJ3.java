package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeSet;

public class HJ3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());

		LinkedList<Integer> list = new LinkedList<>();
		TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o1-o2);
		for (int i = 0; i < num; i++) {
			int t = Integer.parseInt(in.readLine());
			set.add(t);
		}
		for (Integer i :
				set) {
			System.out.print(i+" ");
		}

	}
}
