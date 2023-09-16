package Acwing.Ac908_最大不相交区间数量v;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

class Range implements Comparable<Range>{
    int l,r;

    public Range(int l, int r) {
        this.l = l;
        this.r = r;
    }


    @Override
    public int compareTo(Range o) {
        if(this.l==o.l){
            return this.r-o.r;
        }
        return this.l-o.l;
    }
}
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);

    static int n;
    static final int N = 100005;
    static Range[] slot = new Range[N];
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static void main(String[] args) throws IOException {
        n = nextInt();
        for(int i=0;i<n;i++){
            slot[i]=new Range(nextInt(),nextInt());
        }
        Arrays.sort(slot,0,n);
//        for(int i=0;i<n;i++){
//            System.out.println(slot[i].l+" "+slot[i].r);
//        }

        int res = 1,maxR = slot[0].r;
        for(int i=1;i<n;i++){
            if(slot[i].l<=maxR){ // 判断是否相交
                maxR = Math.min(maxR,slot[i].r);
            }else{
                res++;
                maxR=slot[i].r;
            }
        }
        System.out.println(res);

    }
}
