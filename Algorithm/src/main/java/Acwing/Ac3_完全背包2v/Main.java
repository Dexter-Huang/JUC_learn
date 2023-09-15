package Acwing.Ac3_完全背包2v;

import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int read() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static int n,m;
    private static final int N = 1010;
    static int[][] f = new int[N][N];
    static int[] v = new int[N], w = new int[N];


    public static void main(String[] args) throws IOException {
n = read(); m = read();
for (int i = 1; i <=n ; i++) {
    v[i]=read();w[i]=read();
}

for (int i = 1; i <=n ; i++) {
    for (int j = 1; j <= m ; j++) {
        if(j<v[i])
            f[i][j] = f[i-1][j];
        else
            f[i][j] = Math.max(f[i-1][j],f[i][j-v[i]]+w[i]);

    }
}
out.println(f[n][m]);
        out.flush();
    }
}
