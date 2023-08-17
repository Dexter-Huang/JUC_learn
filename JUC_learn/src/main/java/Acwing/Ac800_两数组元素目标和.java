package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac800_两数组元素目标和 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] A = new int[100005];
    static int[] B = new int[100005];


    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n =buffer[0],m=buffer[1],x=buffer[2];
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(buffer,0,A,0,buffer.length);
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(buffer,0,B,0,buffer.length);

        for (int i = 0,j=m-1; i < n&& j >=0;) {
            if(A[i]+B[j]==x) {
                out.write(i+" "+j);
                break;
            } else if (A[i] + B[j] > x) {
                j--;
            } else if (A[i] + B[j] < x) {
                i++;
            }
        }


        out.flush(); out.close();in.close();
    }
}
