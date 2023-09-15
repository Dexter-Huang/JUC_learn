package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac836_合并集合 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[] buffer,p=new int[100010];

    static int find(int x){
        if (x!=p[x])
            p[x]=find(p[x]);//父亲找祖先
        return p[x];
    }

    public static void main(String[] args) throws IOException {

        buffer= Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = buffer[0];m = buffer[1];
        for (int i = 0; i <= n ; i++) {
            p[i]=i;
        }
        String opt;
        int a,b;
        while (m-- >0){
            opt=in.readLine();
            buffer= Arrays.stream(opt.substring(2).split(" ")).mapToInt(Integer::parseInt).toArray();
            a = buffer[0];b = buffer[1];
            if(opt.startsWith("M")){
                p[find(a)]=find(b);
            }else{
                if(find(a)==find(b))
                    out.write("Yes\n");
                else
                    out.write("No\n");
            }
        }

        out.flush();in.close();out.close();
    }
}
