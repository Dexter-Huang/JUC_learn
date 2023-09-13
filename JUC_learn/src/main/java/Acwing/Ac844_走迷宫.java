package Acwing;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Ac844_走迷宫 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    static int n,m;
    private static final int N = 105;
    static int[][] graph = new int[N][N],dist = new int[N][N];
    static Pair[][] prev = new Pair[N][N];
    static int[] dx={-1,1,0,0};
    static int[] dy={ 0,0,-1,1};
    static Queue<Pair> queue = new LinkedList<>();

    static int bfs(){
        dist[0][0]=0;//起点
        queue.add(new Pair(0,0));
        while (!queue.isEmpty()){
            Pair t = queue.poll();
            for (int i = 0; i <4 ; i++) {
                int x = t.x+dx[i],y=t.y+dy[i];
                if(x>=0&&x<n&&y>=0&&y<m&&graph[x][y]==0&&dist[x][y]==-1){
                    dist[x][y]=dist[t.x][t.y]+1;
                    queue.add(new Pair(x,y));
                    prev[x][y]=t;

                }
            }
        }
        int x =n-1,y=m-1;
        while (!(x==0&&y==0)){
            out.println(x+" "+y);
            Pair t = prev[x][y];
            x=t.x;y=t.y;
        }

        return dist[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        n = read();m =read();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                graph[i][j]=read();
                dist[i][j]=-1;
            }
        }

        out.println(bfs());


        out.flush();
    }
}
