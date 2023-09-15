package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ac796_子矩阵的和 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=buffer[0],m=buffer[1],q=buffer[2];
        int[][] graph = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            int[] tmp = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < tmp.length; j++) {
                graph[i+1][j+1]=graph[i][j+1]+graph[i+1][j]-graph[i][j]+tmp[j];
            }
        }

        while (q-- >0){
            buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1=buffer[0],y1=buffer[1],x2=buffer[2],y2=buffer[3];
            System.out.println(graph[x2][y2]-graph[x1-1][y2]-graph[x2][y1-1]+graph[x1-1][y1-1]);

        }

    }
}
