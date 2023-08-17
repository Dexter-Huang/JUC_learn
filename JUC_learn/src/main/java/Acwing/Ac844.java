package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Ac844 {
    static Queue<AbstractMap.SimpleEntry<Integer,Integer>> que=new ArrayDeque<>();
    static int N = 105;
    static int[][] dist=new int[N][N], graph=new int[N][N];
    static AbstractMap.SimpleEntry<Integer,Integer>[][] prev=new AbstractMap.SimpleEntry[N][N];
    static int n,m;

    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};

    static boolean check(int x,int y){
        return x>0&&y>0&&x<=n&&y<=m&&graph[x][y]==0&&dist[x][y]==-1;
    }

    static void bfs(){
        que.add(new AbstractMap.SimpleEntry<>(1,1));
        while (!que.isEmpty())
        {
            AbstractMap.SimpleEntry<Integer,Integer> head = que.poll();
            for (int i = 0; i < 4; i++) {
                int tx = head.getKey()+dx[i],ty=head.getKey()+dy[i];
                if(check(tx,ty)){
                    que.add(new AbstractMap.SimpleEntry<>(tx,ty));
                    prev[tx][ty]=head;
                    dist[tx][ty]=dist[head.getKey()][head.getValue()]+1;
                }
            }

        }

//        IntStream.rangeClosed(1,n).forEach(
//                i->IntStream.rangeClosed(1,m).mapToObj(j->prev[i][j]).forEach(
//                        o->
//                )
//        );

//        for(int i=1;i<=n;i++){
//            for (int j = 1; j <=m ; j++) {
//                System.out.println(prev[i][j].getKey()+","+prev[i][j].getValue()+"->"+i+","+j+"||");
//            }
//        }

        int x=n,y=m;
        while (x!=0&&y!=0){
            System.out.println(x+","+y);
            AbstractMap.SimpleEntry<Integer,Integer> t =prev[x][y];
            x=t.getKey();
            y=t.getValue();
        }

        System.out.println(dist[n][m]);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

        int[] tmp = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n=tmp[0];
        m=tmp[1];

        for(int i=0;i<dist.length;i++)
            Arrays.fill(dist[i],-1);

        dist[1][1]=0;
        que.add(new AbstractMap.SimpleEntry<>(1,1));

        for(int i=1;i<=n;i++)
            graph[i]= Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();



        bfs();


    }
}
