package Acwing.Ac931_kmp前后缀匹配;

import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    static void buildNext(int[] next, char[] pattern){
        int prefixLen = 0;
        // 下标从1开始，因为第0个肯定next值为0
        int i = 1;
        while (i < pattern.length){
            if(pattern[prefixLen]==pattern[i]){
                prefixLen++;
                next[i]=prefixLen;
                i++;
            }else if(prefixLen>0){
                prefixLen = next[prefixLen-1];
            }else if(prefixLen==0){
                next[i]=0;
                i++;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        char[] pattern = in.readLine().toCharArray();
        int m = nextInt();
        char[] target = in.readLine().toCharArray();
        int[] next = new int[n];
        buildNext(next,pattern);

        int i=0,j=0;
        while (i<target.length){
            if(target[i]==pattern[j]){
                j++;
                i++;
                if(j==pattern.length){
                    out.print(i-pattern.length+" ");
                    j = next[j-1]; // 不是j=0, 由于有next,可以不用从头匹配
                }
            } else if (j > 0) {
                j = next[j-1];
            } else if (j==0){ // 第一个字符就不匹配
                i++;
            }
        }
        out.flush();
    }
}
