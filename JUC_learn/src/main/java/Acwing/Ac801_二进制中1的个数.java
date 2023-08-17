package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac801_二进制中1的个数 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int cal(int a){
        int k =0;
        while (a!=0){
            k+=a&1;
            a>>=1;
        }
        return k;
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(arr).forEach(o-> {
            try {
                out.write(cal(o)+" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });



        in.close();out.flush();out.close();
    }
}
