package Acwing;

import java.io.*;

public class Ac5_多重背包_二进制优化 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static int n,m;
    private static final int N = 12005;
    static int[] v= new int[N], w=new int[N],s=new int[N];
    static int[][] f =new int[N][2005];


    static int cnt =0;
    static void binaryOptimize(int vv,int ww,int ss){
        int k = 1;

        while (k<=ss){
            ++cnt;
            v[cnt]=k*vv;
            w[cnt]=k*ww;

            ss-=k;
            k<<=1;

        }
        if(ss>0){
            ++cnt;
            v[cnt]=ss*vv;
            w[cnt]=ss*ww;
        }
    }

    public static void main(String[] args) throws IOException {
        n = read();m = read();
        int vv,ww,ss;
        for (int i = 1; i <= n ; i++) {
            vv=read();ww=read();ss=read();
            binaryOptimize(vv,ww,ss);
        }
        n = cnt;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j]=f[i-1][j];
                if(j>=v[i])
                    f[i][j]=Math.max(f[i][j],f[i-1][j-v[i]]+w[i]);

            }
        }

        out.println(f[n][m]);

        out.flush();
    }
}
