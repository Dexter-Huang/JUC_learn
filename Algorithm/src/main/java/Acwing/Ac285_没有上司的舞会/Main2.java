package Acwing.Ac285_没有上司的舞会;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main2 {
    static int N = 6010;
    static int n;
    static LinkedList<Integer>[] list = new LinkedList[N];
    static {
        for (int i = 0; i < N; i++) {
            list[i] = new LinkedList<>();
        }
    }
    static int[][] f = new int[N][2];//状态数组.即用0，1表示当前根节点是否选择
    static boolean[] st = new boolean[N];
    static int idx = 1;
    static int[] happy = new int[N];//幸福值
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer reader = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        reader.nextToken();
        return (int) reader.nval;
    }
    static void add(int a, int b) { //建表
          list[a].add(b);
    }

    static void dfs(int u) {
        f[u][1] = happy[u];//标记当前点选择的情况下，快乐度赋值
        for (int i = 0; i < list[u].size(); i++) {
            int son = list[u].get(i);
            dfs(son);
            f[u][1] += f[son][0];//当前点选择的情况下，加上所有子节点不选择的情况下的快乐度
            f[u][0] += Math.max(f[son][0], f[son][1]);//当前点不选择的情况下，加上所有子节点选择的情况下的快乐度
        }
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 1; i <= n; i++) {
            happy[i] = nextInt();
        }
        int m = n - 1;
        while (m-- > 0) {
            int a = nextInt();
            int b = nextInt();
            add(b, a);//因为b是上司因此需要把a连接到b的后面
            st[a] = true;//表示当前节点有父节点
        }
        int root = 1;
        //寻找父节点
        while (st[root])
            root++;
        dfs(root);
        System.out.println(Math.max(f[root][0], f[root][1]));
    }
}
