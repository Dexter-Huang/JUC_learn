package BM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BM61_longestPathInMatrix {
    //记录四个方向
    public static int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int row, col;
    //深度优先搜索，返回最大单元格数
    public static int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j] != 0)
            return dp[i][j];
        dp[i][j]++;
        for (int k = 0; k < 4; k++) {
            int nexti = i + dirs[k][0];
            int nextj = j + dirs[k][1];
            //判断条件
            if(nexti >= 0 && nexti < row && nextj >= 0 && nextj < col && matrix[nexti][nextj] > matrix[i][j])
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, dp, nexti, nextj) + 1);
        }
        return dp[i][j];
    }
    public static int solve (int[][] matrix) {
        //矩阵不为空
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int res = 0;
        row = matrix.length;
        col = matrix[0].length;
        //i，j处的单元格拥有的最长递增路径
        int[][] dp = new int[row + 1][col + 1];
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                //更新最大值
                res = Math.max(res, dfs(matrix, dp, i, j));
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        ArrayList<String> list = new ArrayList<>();
        while (!"".equals(str=br.readLine())){
            list.add(str);
        }
        int rowNum = list.size();
        int colNum = list.get(0).split(",").length;

        int[][] matrix = new int[rowNum][colNum];

        for(int i=0;i<rowNum;i++){
            String[]tmp= list.get(i).split(",");
            for(int j=0;j<tmp.length;j++){
                matrix[i][j]=Integer.parseInt(tmp[j]);
            }
        }

        System.out.println(solve(matrix));


    }
}
