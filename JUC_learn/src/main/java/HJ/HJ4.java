package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder t = new StringBuilder(in.readLine());

		int len = t.length();
		int zeroNum = (len%8==0)?0:8-len%8;
		for (int i = 0; i < zeroNum; i++) {
			t.append("0");
		}

		for (int i = 0; i < t.length(); i+=8) {
			System.out.println(t.substring(i,i+8));
		}
	}
}
