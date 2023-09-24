package Acwing.Ac900_整数划分.完全背包;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws Exception{
        st.nextToken();
        return (int)st.nval;
    }

    static int[][] f = new int[1005][1005];
    static {
//        for(int i=0;i<1005;i++)
//            f[i][0]=1;
        f[0][0]=1;
    }
    static final int MOD = (int)1e9+7;

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        // dp[i][j] 表示前i个整数（1,2…,i）恰好拼成j的方案数
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;j-k*i>=0;k++){
                    f[i][j]+=f[i-1][j-k*i];
                    f[i][j]%=MOD;
                }
            }
        }
        System.out.println(f[n][n]);
    }

}
