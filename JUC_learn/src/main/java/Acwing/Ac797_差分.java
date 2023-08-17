package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Ac797_差分 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int N =100010;
    static int[] arr = new int[N];
    static int[] brr = new int[N];

    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = buffer[0],m=buffer[1];
        int[] tmp = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.arraycopy(tmp,0,arr,1,tmp.length);

        for (int i = 1; i <= n; i++) {
            brr[i]=arr[i]-arr[i-1];
        }

        while (m-- >0){
            buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int l=buffer[0],r=buffer[1],c=buffer[2];
            brr[l]+=c;
            brr[r+1]-=c;
        }

        for (int i = 1; i <= n; i++) {
            arr[i]=brr[i]+arr[i-1];
        }

        IntStream.rangeClosed(1,n).forEach(i-> System.out.print(arr[i]+" "));


    }
}
