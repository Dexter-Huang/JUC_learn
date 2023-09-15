package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac2816_判断子序列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] A = new int[(int)1e5+10];
    static int[] B = new int[(int)1e5+10];


    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n= buffer[0],m=buffer[1];
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(buffer,0,A,0,buffer.length);
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(buffer,0,B,0,buffer.length);

        int i =0;
        for (int j = 0; j < m; j++) {
            if(i<n&&A[i]==B[j])
                i++;
        }

        if(i==n)
            out.write("Yes");
        else
            out.write("No");


        out.flush();out.close();in.close();
    }
}
