package BM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BM57_islandNum {

    public static void dfs(char[][] grid,int i,int j){
        int rowNum = grid.length;
        int colNum = grid[0].length;
        grid[i][j]='0';
        if(i-1>=0&&grid[i-1][j]=='1')
            dfs(grid, i-1, j);
        if(i+1<rowNum&&grid[i+1][j]=='1')
            dfs(grid,i+1,j);
        if(j-1>=0&&grid[i][j-1]=='1')
            dfs(grid,i,j-1);
        if(j+1<colNum&&grid[i][j+1]=='1')
            dfs(grid,i,j+1);
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
        int colNum = list.get(0).split(" ").length;

        char[][] grid = new char[rowNum][colNum];

        for(int i=0;i<rowNum;i++){
            String[]tmp= list.get(i).split(" ");
            for(int j=0;j<tmp.length;j++){
                grid[i][j]=tmp[j].charAt(0);
            }
        }

        //=============================================
        int count = 0;
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        System.out.println(count);


    }
}
