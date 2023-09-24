package Acwing.Ac148_合并果子v;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }
    static int n;
    public static void main(String[] args) throws IOException {
        n = (int)nextLong();
        long[] arr = new long[n];
        long[] sum = new long[n];
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int i=0;i<n;i++){
            minHeap.add(nextLong());
        }
        long res = 0L;
        while (minHeap.size()>1){
            long a =minHeap.poll();
            long b =minHeap.poll();
            res+=(a+b);
            minHeap.add(a+b);
        }
        System.out.println(res);

    }
}
