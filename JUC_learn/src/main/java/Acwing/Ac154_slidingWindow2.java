package Acwing;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Ac154_slidingWindow2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n ,k;

    static int[] buffer;
    static ArrayDeque<Integer> maxIndexQue = new ArrayDeque<>(3);
    // 滑动窗口 模板题
    public static void main(String[] args) throws IOException {
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = buffer[0];k=buffer[1];
        int[] a = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            if(maxIndexQue.size()>0&&i-k+1> maxIndexQue.getFirst())// 判断队首元素是否过期
                maxIndexQue.removeFirst();
            while (maxIndexQue.size()>0&&a[i]<=a[maxIndexQue.getLast()])// 判断单调队列是否需要弹出元素
                maxIndexQue.removeLast();
            maxIndexQue.add(i);
            if(i+1>=k)
                out.write(a[maxIndexQue.getFirst()]+" ");
        }

        maxIndexQue.clear();

        out.write("\n");
        for (int i = 0; i < n; i++) {
            if(maxIndexQue.size()>0&&i-k+1> maxIndexQue.getFirst())
                maxIndexQue.removeFirst();
            while (maxIndexQue.size()>0&&a[i]>=a[maxIndexQue.getLast()])
                maxIndexQue.removeLast();
            maxIndexQue.add(i);
            if(i+1>=k)
                out.write(a[maxIndexQue.getFirst()]+" ");
        }

        out.flush();in.close();out.close();
    }
}
