package Acwing.Ac901_滑雪;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    private static final int N = 310;
    static int n,m;
    static int[][] f = new int[N][N], h = new int[N][N];
    static {
        for(int i=0;i<N;i++){
            Arrays.fill(f[i],-1);
        }
    }
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    static int dp(int x,int y){
        if(f[x][y]!=-1)
            return f[x][y];
        f[x][y]=1;
        for(int i=0;i<4;i++){
            int xx = x+dx[i], yy = y+dy[i];
            if(xx>=1&&xx<=n&&yy>=1&&yy<=m&&h[x][y]>h[xx][yy]){
                f[x][y] = Math.max(f[x][y],dp(xx,yy)+1);
            }
        }
        return f[x][y];
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for(int i= 1;i<=n;i++){
            for(int j=1;j<=m;j++){
                h[i][j]=nextInt();
            }
        }
        int res =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                res = Math.max(res,dp(i,j));
            }
        }
        System.out.println(res);
    }

}
