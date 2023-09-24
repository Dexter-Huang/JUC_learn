package Acwing.Ac903_编辑距离;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);

    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static char[] nextStr() throws IOException {
        st.nextToken();
        return st.sval.toCharArray();
    }
    static int[][] f = new int[1005][1005];
    static {
        for(int i=0;i<1005;i++){
            f[i][0]=i;
            f[0][i]=i;
        }

    }

    static boolean isOk(char[] str, char[] targetStr, int limit){
        int strLen = str.length;
        int targetSTrLen = targetStr.length;
        for(int i=1;i<=strLen;i++){
            for(int j=1;j<=targetSTrLen;j++){
                f[i][j]=Math.min(f[i-1][j]+1,f[i][j-1]+1);
                if(str[i-1]==targetStr[j-1]){
                    f[i][j]=Math.min(f[i][j],f[i-1][j-1]);
                } else{
                    f[i][j]=Math.min(f[i][j],f[i-1][j-1]+1);
                }
            }
        }
        return f[strLen][targetSTrLen]<=limit;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        ArrayList<char[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(nextStr());
        }
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i=0;i<m;i++){
            char[] curTarget = nextStr();
            int limit = nextInt();

            int ans = 0;
            for(int j=0;j<list.size();j++){
                if(isOk(list.get(j),curTarget,limit))
                    ans++;
            }
            ansList.add(ans);
        }
        ansList.forEach(System.out::println);


    }
}
