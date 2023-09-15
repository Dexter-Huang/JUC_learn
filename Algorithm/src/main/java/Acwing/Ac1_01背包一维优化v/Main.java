package Acwing.Ac1_01背包一维优化v;

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
    static int[] f = new int[N];
    static int[] v = new int[N], w = new int[N];

    public static void main(String[] args) throws IOException {
        n = read(); m =read();
        for (int i = 1; i <=n ; i++) {
            v[i]=read();w[i]=read();
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = m; j >=v[i] ; j--) {
                f[j]=Math.max(f[j],f[j-v[i]]+w[i]);
            }
        }
        out.println(f[m]);

        out.flush();
    }

}
