package Acwing.Ac282_石子合并;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static int[][] f = new int[305][305];
    static {
        for(int i=0;i<305;i++){
            Arrays.fill(f[i],0x3f3f3f3f);
        }
    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=nextInt();
            sum[i]=(sum[i-1]+arr[i]);
        }

        for(int len = 1;len<=n;len++){ // 区间长度
            for(int i=1;i+len-1<=n;i++){ // 枚举起点
                int j = i+len-1;       // 区间终点
                if(len==1){
                    f[i][j]=0;
                    continue;
                }
                for(int k=i;k<=j-1;k++){
                    f[i][j]=Math.min(f[i][j],f[i][k]+f[k+1][j]+sum[j]-sum[i-1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }

}
