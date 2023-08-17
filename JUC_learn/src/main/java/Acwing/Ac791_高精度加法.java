package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ac791_高精度加法 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int[] A=new int[100010];
    static int[] B=new int[100010];
    static int[] C=new int[100010];

    static int Add(int[]a,int[]b,int[]c,int cnt){
        int t = 0;
        for (int i = 0; i <cnt ; i++) {
            t+=(a[i]+b[i]);
            c[i] = t%10;
            t/=10;
        }

        if(t!=0){
            c[cnt]=1;
            cnt++;
        }

        return cnt;//返回结果位数
    }

    public static void main(String[] args) throws IOException {
        char[] a = in.readLine().toCharArray();
        char[] b = in.readLine().toCharArray();

        int cnt1 = 0;
        for (int i = a.length-1; i >=0; i--) {
            A[cnt1++] = a[i]-'0';
        }

        int cnt2 = 0;
        for (int i = b.length-1; i >=0; i--) {
            B[cnt2++] = b[i]-'0';
        }

        int cnt3 = Add(A,B,C,Math.max(a.length,b.length));

        for (int i = cnt3-1; i >=0 ; i--) {
            System.out.print(C[i]);
        }

    }
}
