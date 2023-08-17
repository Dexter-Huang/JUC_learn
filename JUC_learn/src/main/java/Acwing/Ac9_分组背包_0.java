package Acwing;

import java.io.*;

public class Ac9_分组背包_0 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static int n,m;
    private static final int N = 105;
    static int[][] v= new int[N][N],w=new int[N][N],f=new int[N][N];
    static int[] s = new int[N];


    public static void main(String[] args) throws IOException {
        n = read();m=read();
        for (int i = 1; i <= n ; i++) {
            s[i]=read();
            for (int j = 1; j <= s[i] ; j++) {
                v[i][j]=read();
                w[i][j]=read();
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j]= f[i-1][j];
                for (int k = 1; k <=s[i] ; k++) {
                    if(j>=v[i][k])
                        f[i][j]=Math.max(f[i][j],f[i-1][j-v[i][k]]+w[i][k]);
                }
            }
        }

        out.println(f[n][m]);

        out.flush();
    }
}
