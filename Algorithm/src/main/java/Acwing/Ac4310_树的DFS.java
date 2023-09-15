package Acwing;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ac4310_树的DFS {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    private static final int N = 200010;
    static int n,q;
    static int[] a= new int[N];
    static int[] cnt = new int[N];
    static ArrayList<Integer>[] h;

    static ArrayList<Integer> p = new ArrayList();
    static boolean[] vis = new boolean[N];
    static int dfs(int x){
        p.add(x);
        cnt[x]=1;
        for (Integer s:h[x]) {
            cnt[x]+=dfs(s);
        }
        return cnt[x];
    }

    static int[] buffer;



    public static void main(String[] args) throws IOException {
        n = read();q=read();
        h = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            h[i]= new ArrayList<>();
        }
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 2; i <= n ; i++) {
            h[buffer[i-2]].add(i);
        }
        dfs(1);
        for (int i = 0; i < p.size(); i++) {
            a[p.get(i)] = i;
        }

        while (q-- >0){
            int u,k;
            buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            u = buffer[0];k=buffer[1];
            if(cnt[u]<k)
                out.println("-1");
            else
                out.printf("%d\n",p.get(a[u]+k-1));
        }
        out.flush();
    }
}
