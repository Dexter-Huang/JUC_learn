package Acwing.Ac900_整数划分.计数DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int[][] f = new int[1005][1005];
    static final int MOD = (int)1e9+7;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        // f[i][j] 表示总和为i, 组成有j个数 的方案
        f[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                f[i][j] = (f[i-1][j-1]+f[i-j][j])%MOD;
            }
        }

        // ans = (f[n][1]+...+f[n][n])
        int res = 0;
        for(int i=1;i<=n;i++){
            res = (res+f[n][i])%MOD;
        }
        System.out.println(res);
    }


}
