package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ac793_高精度乘法 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int[] A = new int[100010];
    static int[] B = new int[100010];
    static int[] C = new int[100010];

    static int mul(int[]a, int[]b, int cnt1,int cnt2){
        for (int i = 0; i < cnt1; i++) {
            for (int j = 0; j < cnt2 ; j++) {
                C[i+j]+=a[i]*b[j];
            }
        }

        int t =0;
        for (int i = 0; i <cnt1+cnt2+1 ; i++) {
            t+=C[i];
            C[i] = t%10;
            t/=10;
        }
        int zero_num = 0;
        for (int i = cnt1+cnt2; i >=0 ; i--) {
            if(C[i]==0)
                zero_num++;
            else
                break;
        }

        return cnt1+cnt2+1-zero_num;

    }
    public static void main(String[] args) throws IOException {
        char[] a= in.readLine().toCharArray();
        char[] b= in.readLine().toCharArray();
        int cnt1=0;
        for (int i = a.length-1; i >=0; i--) {
            A[cnt1++]=a[i]-'0';
        }

        int cnt2=0;
        for (int i = b.length-1; i >=0; i--) {
            B[cnt2++]=b[i]-'0';
        }

        int cnt3 = mul(A,B,cnt1,cnt2);
        for (int i = cnt3-1; i >= 0; i--) {
            System.out.print(C[i]);
        }
        if(cnt3==0)
            System.out.print(0);
    }
}
