package Acwing.Ac913_排队打水;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static long nextLong() throws Exception{
        st.nextToken();
        return (long)st.nval;
    }
    static int n;
    public static void main(String[] args) throws Exception {
        n = (int)nextLong();
        long[] arr = new long[n];
        long[] sum = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = nextLong();
        }
        Arrays.sort(arr);
        sum[0] = 0;
        long ans = 0;
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1]+arr[i-1];
            ans+=sum[i];
        }
        System.out.println(ans);
    }
}
