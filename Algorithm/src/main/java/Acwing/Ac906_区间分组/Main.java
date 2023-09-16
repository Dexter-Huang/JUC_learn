package Acwing.Ac906_区间分组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge implements Comparable<Edge>{
    int l,r;

    public Edge() {
        this.l=0;
        this.r=0;
    }

    public Edge(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "l=" + l +
                ", r=" + r +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        if(this.l<o.l){
            return -1;
        }else if(this.l>o.l){
            return 1;
        }else {
            return 0;
        }
    }
}
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    private static final int N = 100005;
    static Edge[] arr = new Edge[N];
    static int n;
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static void main(String[] args) throws IOException {
        n=nextInt();
        for(int i=0;i<n;i++){
            arr[i]=new Edge(nextInt(),nextInt());
        }

        Arrays.sort(arr,0,n);
        Queue<Integer> minHeap = new PriorityQueue<>();
//        for(int i=0;i<n;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
        for(int i=0;i<n;i++){
            int l = arr[i].l;
            int r = arr[i].r;
            if(minHeap.isEmpty()||l<=minHeap.peek()){
                minHeap.add(r);
            }else{
                int min_r = minHeap.poll();
                minHeap.add(Math.max(min_r,r));
            }
        }

        System.out.println(minHeap.size());
    }

}
