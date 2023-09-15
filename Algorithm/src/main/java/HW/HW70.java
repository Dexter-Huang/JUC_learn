package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW70 {
    static class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            dp[1]=1;
            if(n>1)
                dp[2]=2;
            for (int i = 3; i <= n ; i++) {
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n];
        }

        public Solution() {
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(in.readLine());
        Solution s = new Solution();
        System.out.println(s.climbStairs(t));;
    }
}
