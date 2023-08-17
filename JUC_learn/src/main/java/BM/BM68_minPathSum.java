package BM;

import java.util.Scanner;

public class BM68_minPathSum {
    public static int minPathSum(int[][] matrix){
        int rowLen = matrix.length;
        int colLen=matrix[0].length;
        int[][] dp =new int[rowLen][colLen];
        dp[0][0]=matrix[0][0];
        for(int i=1;i<rowLen;i++)
            dp[i][0]=dp[i-1][0]+matrix[i][0];

        for(int i =1;i<colLen;i++)
            dp[0][i]=dp[0][i-1]+matrix[0][i];

        for(int i =1;i<rowLen;i++){
            for(int j=1;j<colLen;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }

        return dp[rowLen-1][colLen-1];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(),n=in.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=in.nextInt();
            }
        }




    }
}
