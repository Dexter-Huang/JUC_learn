package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ac792_高精度减法 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static int[] A=new int[100010];
    static int[] B=new int[100010];
    static int[] C=new int[100010];

    static String cmp(int[]a,int[]b,int cnt1,int cnt2){
        if(cnt1!=cnt2)
            return cnt1>cnt2?"true":"false";
        else {
            for (int i = cnt1; i >=0; i--) {
                if(a[i]!=b[i])
                    return a[i]>b[i]?"true":"false";
            }
            return "equal";
        }
    }

    static int sub(int[]a ,int[]b, int cnt1,int cnt2){
        int t = 0;
        int cnt3=0;
        for (int i = 0; i <=cnt1 ; i++) {
            t = a[i]-t-b[i];
            C[cnt3++]=((t+10)%10);
            if(t<0)
                t=1;
            else
                t=0;
        }
        int zero_num = 0;
        for (int i = cnt3-1; i >=0 ; i--) {
            if(C[i]==0)
                zero_num++;
            else
                break;
        }

        return cnt3-zero_num;
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

        int cnt3 = 0;
        String ans = cmp(A,B,cnt1,cnt2);
        if(ans.equals("equal"))
            System.out.println(0);
        else if (ans.equals("true")) {//A>B
            cnt3 = sub(A,B,cnt1,cnt2);
            for (int i = cnt3-1; i >=0 ; i--) {
                System.out.print(C[i]);
            }
        }
        else {//B>A
            cnt3 = sub(B,A,cnt2,cnt1);
            System.out.print("-");
            for (int i = cnt3-1; i >=0 ; i--) {
                System.out.print(C[i]);
            }
        }

    }
}
