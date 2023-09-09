package Acwing.Ac3_完全背包1v;

import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    static int n,m;
    private static final int N = 1010;
    static int[] v = new int[N], w = new int[N];
    static int[][] f = new int[N][N];//f[i][j] 前 i 个物品，背包容量 j 下的最优解

    public static void main(String[] args) throws IOException {
        n = read();m = read();
        for (int i = 1; i <= n ; i++) {
            v[i]=read();w[i]=read();
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k*v[i]<=j ; k++) {
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-k*v[i]]+k*w[i]);
                }
            }
        }

        out.println(f[n][m]);
        out.flush();
    }
}
