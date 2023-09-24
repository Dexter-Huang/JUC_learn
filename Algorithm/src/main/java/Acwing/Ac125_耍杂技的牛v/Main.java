package Acwing.Ac125_耍杂技的牛v;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

class Cow implements Comparable<Cow>{
    long w,s;

    public Cow(long w, long s) {
        this.w = w;
        this.s = s;
    }

    @Override
    public int compareTo(Cow o) {
        long ans = (this.w+this.s)-(o.w+o.s);
        if(ans<0){
            return -1;
        } else if(ans>0){
            return 1;
        }
        return 0;
    }
}
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static long nextLong() throws IOException {
        st.nextToken();
        return (long)st.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = (int)nextLong();
        Cow[] arr = new Cow[n];
        for(int i=0;i<n;i++){
            arr[i]=new Cow(nextLong(),nextLong());
        }
        Arrays.sort(arr);
        long ans = -arr[0].s;
        long[] sum = new long[n];
        sum[0]=arr[0].w;
        for(int i=1;i<n;i++){
            sum[i]+=(sum[i-1]+arr[i].w);
            ans=Math.max(sum[i-1]-arr[i].s,ans);
        }
        System.out.println(ans);
    }
}
