package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] str = in.readLine().substring(2).toCharArray();
		long ans = 0;
		int len = str.length;
		for (int i = len-1; i >=0; i--) {
			if((int)str[i]>=65){
				ans+=((long)str[i]-55L)* Math.pow(16,len-i-1);
			}
			else{
				ans+=((long)str[i]-48L)* Math.pow(16,len-i-1);
			}
		}

//		System.out.println((long)Math.pow(8,1));
//		System.out.println((long)'A');
//		System.out.println((long)'0');
		System.out.println(ans);

	}
}
