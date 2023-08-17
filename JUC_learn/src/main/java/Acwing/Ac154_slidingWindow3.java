package Acwing;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Ac154_slidingWindow3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,k;
    static int[] buffer;

    static ArrayDeque<Integer> maxIndexQue = new ArrayDeque<>();
    static ArrayDeque<Integer> minIndexQue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = buffer[0];k =buffer[1];
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            if(maxIndexQue.size()>0&&i-k+1>maxIndexQue.getFirst())
                maxIndexQue.removeFirst();
            while (maxIndexQue.size()>0&&arr[i]<=arr[maxIndexQue.getLast()])
                maxIndexQue.removeLast();
            maxIndexQue.add(i);
            if(i-k+1>=0)
                out.write(arr[maxIndexQue.getFirst()]+" ");
        }


        out.write("\n");

        for (int i = 0; i < n; i++) {
            if(minIndexQue.size()>0&&i-k+1>minIndexQue.getFirst())
                minIndexQue.removeFirst();
            while (minIndexQue.size()>0&&arr[i]>=arr[minIndexQue.getLast()])
                minIndexQue.removeLast();
            minIndexQue.add(i);
            if(i-k+1>=0)
                out.write(arr[minIndexQue.getFirst()]+" ");
        }

        out.flush();in.close();out.close();
    }

}
