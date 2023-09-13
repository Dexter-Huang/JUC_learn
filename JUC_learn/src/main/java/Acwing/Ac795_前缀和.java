package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ac795_前缀和 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=buffer[0],m=buffer[1];
        int[] tmp = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int[] prefixSum = new int[tmp.length+1];
        for (int i = 0; i < tmp.length; i++) {
            prefixSum[i+1]=prefixSum[i]+tmp[i];
        }


        int L,R;
        while (m-- >0){
            buffer =  Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            L = buffer[0];
            R = buffer[1];
            System.out.println(prefixSum[R]-prefixSum[L-1]);
        }
    }
}
