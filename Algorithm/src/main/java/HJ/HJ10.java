package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class HJ10 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = in.readLine().toCharArray();

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if((int)arr[i]<=128&&(int)arr[i]>=0){
                set.add(arr[i]);
            }
        }

        System.out.println(set.size());
    }
}
