package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac154_slidingWindow {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n ,k;

    static int[] buffer,q=new int[1000010];

    public static void main(String[] args) throws IOException {
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = buffer[0];k=buffer[1];
        int[] a = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int hh=0,tt=-1;
        for (int i = 1; i <= n; i++) {
            if(i-k+1>q[hh])
                hh++;
            while (hh<=tt&&a[i]<=a[q[tt]])
                --tt;
            q[++tt]=i;
            if(i+1>=k)
                out.write(a[q[hh]]+" ");
        }

        out.write("\n");
        hh=0;tt=-1;
        for (int i = 0; i < n; i++) {
            if(i-k+1>q[hh])
                hh++;
            while (hh<=tt&&a[i]>=a[q[tt]])
                --tt;
            q[++tt]=i;
            if(i+1>=k)
                out.write(a[q[hh]]+" ");
        }

        out.flush();in.close();out.close();
    }

}
