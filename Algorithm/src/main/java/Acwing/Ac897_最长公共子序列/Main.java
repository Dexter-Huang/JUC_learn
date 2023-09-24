package Acwing.Ac897_最长公共子序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static String nextStr() throws IOException {
        st.nextToken();
        return st.sval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        char[] s1 = nextStr().toCharArray(), s2 = nextStr().toCharArray();
        int[][] f = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1]){
                    f[i][j]=f[i-1][j-1]+1;
                }else{
                    f[i][j]=Math.max(f[i-1][j],f[i][j-1]);
                }
            }
        }

        System.out.println(f[n][m]);
    }


}
