package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac837_连通块中点的数量 {
    static BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,m;
    static int[] buffer,siz,p;

    static int t2=0;

    static int find(int x){
        if(x!=p[x])
            p[x]=find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n=buffer[0];m=buffer[1];
        p = new int[n+1];siz=new int[n+1];

        for (int i = 0; i <=n ; i++) {
            p[i]=i;
            siz[i]=1;
        }
        String opt;
        int a,b;
        while (m-- >0){
            opt=in.readLine();
            if(opt.startsWith("C")){
                buffer = Arrays.stream(opt.substring(2).split(" ")).mapToInt(Integer::parseInt).toArray();
                a = buffer[0];b = buffer[1];
                int pa = find(a),pb = find(b);
                if(pa!=pb){
                    siz[pb]+=siz[pa];
                    p[pa]=pb;//pa的父亲是pb
                }


            } else if (opt.startsWith("Q1")) {
                buffer = Arrays.stream(opt.substring(3).split(" ")).mapToInt(Integer::parseInt).toArray();
                a= buffer[0];b=buffer[1];
                if(find(a)==find(b))
                    out.write("Yes\n");
                else
                    out.write("No\n");

            } else {//Q2
                a = Integer.parseInt(opt.split(" ")[1]);
                out.write(siz[find(a)]+"\n");
            }
        }


        out.flush();in.close();out.close();
    }
}
