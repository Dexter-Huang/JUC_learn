package BM;

import java.util.Scanner;

public class BM65_LCS {

    public static String LCS(String s1, String s2){
        int len1=s1.length(),len2=s2.length();
        String ans ="";
        int[][] dp =new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i=len1,j=len2;
        while (dp[i][j]!=0){
            if(dp[i-1][j]==dp[i][j])
                i--;
            else if(dp[i][j-1]==dp[i][j])
                j--;
            else{
                i--;
                j--;
                ans+=s1.charAt(i);
            }
        }
        if("".equals(ans))
            ans= "-1";
        else
            ans=new StringBuilder(ans).reverse().toString();

        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        System.out.println(LCS(s1,s2));


    }
}
