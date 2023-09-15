package BM;

import java.util.Scanner;

public class BM66_LCS {
    public static String LCS(String s1,String s2){
        int len1 = s1.length(),len2=s2.length();

        int[][] dp= new int[len1+1][len2+1];
        int maxLen = 0,pos=0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(maxLen<dp[i][j]){
                        maxLen=dp[i][j];
                        pos=i-1;
                    }
                }
            }
        }

        return (s1.substring(pos-maxLen+1,pos+1));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine(),s2= in.nextLine();

    }
}
