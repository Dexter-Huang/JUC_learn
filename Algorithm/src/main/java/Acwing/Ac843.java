package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ac843 {


    static int target_num;
    static int N=12;
    static char[][] ans = new char[N][N];
    static boolean[] col =new boolean[N],dg=new boolean[2*N],udg=new boolean[2*N];

    static void dfs(int cur_row){
        if(cur_row==target_num+1){
            for (int i = 1; i <= target_num; i++) {
                for (int j = 1; j <= target_num; j++) {
                    System.out.print(ans[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }


        for (int i = 1; i <= target_num ; i++) {
            if(!col[i]&&!dg[i+cur_row]&&!udg[i-cur_row+target_num]){
                ans[cur_row][i]='Q';
                col[i]=dg[i+cur_row]=udg[i-cur_row+target_num]=true;
                dfs(cur_row+1);
                col[i]=dg[i+cur_row]=udg[i-cur_row+target_num]=false;
                ans[cur_row][i]='.';
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        target_num = Integer.parseInt(in.readLine());
        for(int i=1;i<=target_num;i++)
            for(int j=1;j<=target_num;j++)
                ans[i][j]='.';


        dfs(1);

    }
}
