package Acwing.Ac900_整数划分.LC70_爬楼梯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=2;j++){
                if(i-j>=0)
                    f[i]+=f[i-j];
            }
        }
        return f[n];
    }
}
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        Solution s = new Solution();
        System.out.println(s.climbStairs(n));
    }
}
