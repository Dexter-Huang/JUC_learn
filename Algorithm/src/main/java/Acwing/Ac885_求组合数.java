package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac885_求组合数 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] buffer;
    static long[][] f = new long[2005][2005];

    static long MOD = (long)(1e9+7);

    static {
        for (int i = 0; i <= 2000; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0)
                    f[i][j]=1;
                else
                    f[i][j]=(f[i-1][j]+f[i-1][j-1])%MOD;
            }
        }
    }
    static int a,b;
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(in.readLine());
        while (num-- >0){
            buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            a = buffer[0]; b = buffer[1];
            out.write(f[a][b]+"\n");
        }

        out.flush();in.close();out.close();
    }
}
