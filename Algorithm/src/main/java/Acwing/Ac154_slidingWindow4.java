package Acwing;

import java.io.*;
import java.util.ArrayDeque;

public class Ac154_slidingWindow4 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int read() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static ArrayDeque<Integer> maxIndexQue = new ArrayDeque<>();
    static ArrayDeque<Integer> minIndexQue = new ArrayDeque<>();

    static int n,k;

    public static void main(String[] args) throws IOException {
        n = read();k=read();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=read();
        }

        for (int i = 0; i < n; i++) {
            if(maxIndexQue.size()>0&&i-k+1> maxIndexQue.getFirst())
                maxIndexQue.removeFirst();
            while (maxIndexQue.size()>0&&arr[i]<= arr[maxIndexQue.getLast()])
                maxIndexQue.removeLast();
            maxIndexQue.add(i);
            if(i-k+1>=0)
                out.print(arr[maxIndexQue.getFirst()]+" ");
        }
        out.println();
        for (int i = 0; i < n; i++) {
            if(minIndexQue.size()>0&&i-k+1>minIndexQue.getFirst())
                minIndexQue.removeFirst();
            while (minIndexQue.size()>0&&arr[i]>= arr[minIndexQue.getLast()])
                minIndexQue.removeLast();
            minIndexQue.add(i);
            if(i-k+1>=0)
                out.print(arr[minIndexQue.getFirst()]+" ");
        }

        out.flush();
    }

}
