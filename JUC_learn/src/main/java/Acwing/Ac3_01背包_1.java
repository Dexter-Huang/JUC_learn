package Acwing;

import java.io.*;

public class Ac3_01背包_1 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[] v = new int[1005],w = new int[1005];
    static int[][] f = new int[1005][1005]; //f[i][j]前 i 个物品，背包容量 j 下的最优解


    public static void main(String[] args) throws IOException {
        n = read();m=read();
        for (int i = 1; i <= n ; i++) {
            v[i]=read();w[i]=read();
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                f[i][j]=f[i-1][j];
                if(j>=v[i])
                    f[i][j]=Math.max(f[i][j],f[i-1][j-v[i]]+w[i]);
            }
        }

        out.println(f[n][m]);
        out.flush();

    }
}
