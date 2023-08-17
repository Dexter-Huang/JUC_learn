package Acwing;

import java.io.*;

public class Ac23_矩阵中的路径 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static char readChar() throws IOException {
        st.nextToken();
        return st.sval.charAt(0);
    }

    static int read() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static char[][] matrix = new char[100][100];
    static int[] dx ={-1,1,0,0},dy = {0,0,-1,1};

    public static boolean hasPath(char[][] matrix, String str) {
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(dfs(matrix,str,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] matrix,String str,int u, int x,int y){
        if(str.charAt(u)!=matrix[x][y])
            return false;
        if(u==str.length()-1)
            return true;
        char tmp = matrix[x][y];
        matrix[x][y]='*';
        for (int i = 0; i < 4; i++) {
            int a = x+dx[i],b=y+dy[i];
            if(a>=0&&a<matrix.length&&b>=0&&b<matrix[a].length){
                if(dfs(matrix,str,u+1,a,b))
                    return true;
            }
        }
        matrix[x][y]=tmp;

        return false;
    }


    public static void main(String[] args) throws IOException {
        int n = read(),m = read();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                matrix[i][j]=readChar();
            }
        }

        String str = in.readLine();


        out.flush();
    }
}
