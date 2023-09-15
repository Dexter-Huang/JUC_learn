package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Ac842 {
    static final int N = 10;
    static int target;

    static boolean[] vis = new boolean[N];

    static int[] path = new int[N];

    public static void dfs(int cur){
        if(cur==target){
            IntStream.range(0,target).mapToObj(i->path[i]).forEach(o-> System.out.print(o+" "));
//            Arrays.stream(path).forEach(o-> System.out.print(o+" "));
            System.out.println();
        }

        for(int i=1;i<=target;i++){
            if(!vis[i]){
                path[cur]=i;
                vis[i]=true;
                dfs(cur+1);
                vis[i]=false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(in.readLine());

        dfs(0);



    }
}
