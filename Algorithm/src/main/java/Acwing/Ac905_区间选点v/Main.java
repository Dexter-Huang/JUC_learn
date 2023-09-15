package Acwing.Ac905_区间选点v;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

class Range implements Comparable<Range>{
    int l;
    int r;
    public Range(int l,int r){
        this.l = l;
        this.r = r;
    }
    // 重写compareTo方法
    @Override
    public int compareTo(Range o){
        if(this.r!=o.r)
            return this.r-o.r;
        else
            return this.l-o.l;
    }
}

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);
    static int read() throws Exception{
        st.nextToken();
        return (int)st.nval;
    }

    private static final int  N = 100005;
    static Range[] ranges = new Range[N];

    public static void main(String[] args) throws Exception {
        int n = 0;

        n = read();
        for (int i = 0; i < n; i++) {
            int l = read();
            int r = read();
            ranges[i] = new Range(l,r);
        }

        // 对区间进行排序
        Arrays.sort(ranges,0,n);
        System.out.println(Long.MIN_VALUE);

        long res = 0, ed = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(ranges[i].l>ed){
                res++;
                ed = ranges[i].r;
            }
        }

        out.println(res);
        out.flush();

    }
}
