package Acwing.Ac285_没有上司的舞会;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N = 6010;
    static int n;
    static int[] h = new int[N], ne = new int[N], e = new int[N];
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
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++; // h 存储的是当前节点的最后一条边的下标
//        System.out.println();
//        System.out.println("a:"+a+" b:"+b);
//        System.out.println("e :"+Arrays.toString(e));
//        System.out.println("ne:"+Arrays.toString(ne));
//        System.out.println("h :"+Arrays.toString(h));
//        System.out.println("idx:"+idx);

    }

    static void dfs(int u) {
        f[u][1] = happy[u];//标记当前点选择的情况下，快乐度赋值
        for (int i = h[u]; i != -1; i = ne[i]) {//遍历所有子树，计算选择和不选择情况下的快乐度数
            int j = e[i];
            dfs(j);//遍历当前子树，将子树中的情况都赋值快乐度。
            f[u][0] += Math.max(f[j][0], f[j][1]); //不选择当前节点
            f[u][1] += f[j][0]; //选择当前节点，为了使得快乐度最大，子树不应该参与
        }
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 1; i <= n; i++) {
            happy[i] = nextInt();
        }
        Arrays.fill(h, -1);
        int m = n - 1;
        while (m-- > 0) {
            int a = nextInt();
            int b = nextInt();
            add(b, a);//因为b是上司因此需要把a连接到b的后面
            st[a] = true;//表示当前节点有父节点
        }
        int root = 1;
        while (st[root]) {//寻找父节点
            root++;
        }
        dfs(root);
        System.out.println(Math.max(f[root][0], f[root][1]));

    }
}
