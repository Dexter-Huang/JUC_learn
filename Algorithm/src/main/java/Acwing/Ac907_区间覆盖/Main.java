package Acwing.Ac907_区间覆盖;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Stack;

class Range implements Comparable<Range>{
    int l,r;

    public Range(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Range o) {
        if(this.l<o.l){
            return -1;
        } else if (this.l > o.l) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Range{" +
                "l=" + l +
                ", r=" + r +
                '}';
    }
}

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st =new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static int s,t,n;
    static final int N =100005;
    public static void main(String[] args) throws IOException {
        s=nextInt();
        t=nextInt();
        n=nextInt();
        Range[] arr = new Range[n];
        for(int i=0;i<n;i++){
            arr[i]=new Range(nextInt(),nextInt());
        }
//        Arrays.sort(arr,0,arr.length);
//        Arrays.stream(arr).forEach(System.out::println);
//        System.out.println("-----");
        arr= Arrays.stream(arr).filter(o->o.r>=s&&o.l<=t).sorted().toArray(Range[]::new);
//        Arrays.sort(arr,0,arr.length);
//        Arrays.stream(arr).forEach(System.out::println);

        int res = 0;
        boolean isOk = false;
        int tag = s;


        for(int i=0;i<arr.length;){
//            System.out.println(i);
            int j = i,curTag = tag;
            if(tag<arr[j].l){
                break;
            }
            while (j<arr.length&&arr[j].l<=tag){
                curTag = Math.max(curTag,arr[j].r);
                j++;
            }


            res++;
            if(curTag>=t){
                isOk = true;
                break;
            }
            i=j;
            tag = curTag;
        }

        if(!isOk)
            System.out.println(-1);
        else
            System.out.println(res);



    }
}
