package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class DFS_list {

    //DFS 打印路径
    static int N = 100;
    static LinkedList<Integer>[]list = new LinkedList[N];

    static LinkedList<Integer> path = new LinkedList<>();

    static {
        for (int i = 0; i < list.length; i++) {
            list[i]=new LinkedList<>();
        }
    }

    static boolean[] vis = new boolean[N];

    public static void dfs(int cur){
        if(list[cur].size()==0){//到达叶子节点
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i)+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if(!vis[next]){
                vis[next]=true;
                path.add(next);
                dfs(next);
                vis[next]=false;
                path.removeLast();
            }
        }
    }


    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(in.readLine());

        for (int i = 0; i < num; i++) {
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[arr[0]].add(arr[1]);
        }

        path.add(1);

        dfs(1);


    }
}
