package Acwing.Ac902_最短编辑距离;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    static String nextStr() throws IOException {
        st.nextToken();
        return st.sval;
    }

    static int min(int a, int b, int c){
        int minTmp = Math.min(a,b);
        return Math.min(minTmp,c);
    }
    public static void main(String[] args) throws IOException {
        int n,m;
        n = nextInt(); char[] s1 = nextStr().toCharArray();
        m = nextInt(); char[] s2 = nextStr().toCharArray();
        int[][] f = new int[n+1][m+1];
        for(int i=0;i<=m;i++)
            f[0][i]=i;
        for(int i=0;i<=n;i++)
            f[i][0]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1]){
                    f[i][j]=min(f[i-1][j]+1,f[i][j-1]+1,f[i-1][j-1]);
                }else{
                    f[i][j]=min(f[i-1][j]+1, f[i][j-1]+1,f[i-1][j-1]+1);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
