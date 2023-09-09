package Acwing;

import java.io.*;

public class Ac831_kmp {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int n,m;
    static char[] son=new char[100020],fa=new char[100020],buffer;
    static int[] next=new int[100020];

    public static void main(String[] args) throws IOException {
n = read();
buffer = in.readLine().toCharArray();
System.arraycopy(buffer,0,son,1,buffer.length);
m = read();
buffer = in.readLine().toCharArray();
System.arraycopy(buffer,0,fa,1,buffer.length);
// 求next 预处理son
for (int i = 2,j=0; i <=n ; i++) {
    while (j!=0&&son[i]!=son[j+1])
        j = next[j];
    if(son[i]==son[j+1])
        j++;
    next[i]=j;
}

// 匹配fa
for (int i = 1,j=0; i <=m ; i++) {
    while (j!=0&&fa[i]!=son[j+1])
        j = next[j];
    if(fa[i]==son[j+1])
        j++;
    if(j==n){
        out.print(i-n+" ");
        j = next[j];
    }
}



        out.flush();
    }
}
