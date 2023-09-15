package BM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BM97_螺旋矩阵 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public ArrayList<Integer> spiralOrder(int[][] matrix){
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length==0)
            return res;
        int row = matrix.length,col=matrix[0].length;
        return null;
    }

    static void circle(int[][]matrix,int x1,int y1,int x2,int y2,ArrayList<Integer> ans){
        if(x2<x1||y2<y1)
            return;
        if(x1==x2){
            for (int i = y1; i <=y2 ; i++) {
                ans.add(matrix[x1][i]);
            }
            return;
        }
        if(y1==y2){
            for (int i = y1; i <= y2 ; i++) {
                ans.add(matrix[i][y2]);
            }
            return;
        }
        for (int i = y1; i < y2; i++) {
            ans.add(matrix[x1][i]);
        }
        for (int i = x1; i < x2; i++) {
            ans.add(matrix[i][y1]);
        }

    }

    public static void main(String[] args) {

    }
}
