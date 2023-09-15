package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac798_差分矩阵 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr = new int[1005][1005];

    static int[][] brr = new int[1005][1005];

    static void insert(int x1,int y1,int x2,int y2, int c){
        brr[x1][y1]+=c;
        brr[x1][y2+1]-=c;
        brr[x2+1][y1]-=c;
        brr[x2+1][y2+1]+=c;
    }


    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=buffer[0],m=buffer[1],q=buffer[2];
        for (int i = 1; i <= n; i++) {
            buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(buffer,0,arr[i],1,buffer.length);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i,j,i,j,arr[i][j]);
            }
        }

        while (q-- >0){
            buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1=buffer[0],y1=buffer[1],x2=buffer[2],y2=buffer[3],c=buffer[4];
            insert(x1,y1,x2,y2,c);
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                arr[i][j]=brr[i][j]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                out.write(arr[i][j]+" ");
            }
            out.write("\n");
        }
        out.flush();

        out.close();
        in.close();
    }
}
