package Acwing.Ac338_计数DP;

import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);
    static final int N = (int)1e7+5;
    static int[] num = new int[N];
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static int getNum(int l,int r){ // 算出数组num[]第r位到第l位的数
        int res = 0;
        for(int i=l;i>=r;i--){
            res = res*10+num[i];
        }
        return res;
    }

    static int pow10(int i){
        int res = 1;
        while(i-->0) res*=10;
        return res;
    }

    static int work(int n, int x){ // 1到n中 x出现个数
        if(n==0) return 0;
        int len = 0; // len表示n的位数
        while(n>0){
            ++len; // num[]从1开始存储
            num[len] = n%10; // num[]存储n的每一位
            n/=10;
        }
        int ans = 0;
        if(x!=0){ // x>0时，不需要特殊处理
            for(int i=len;i>=1;i--){
                if(i<len){
                    ans+=getNum(len,i+1)*pow10(i-1);
                }
                if(num[i]==x){
                    ans+=getNum(i-1,1)+1;
                } else if (num[i]>x){
                    ans+=pow10(i-1);
                } else {
                    ans+=0;
                }
            }
        } else { // x==0时，需要特殊处理
            for(int i=len;i>0;i--){
                ans+=(getNum(len,i+1)-1)*pow10(i-1); // 0不能出现在最高位
                if(num[i]==x){ // 0出现在第i位
                    ans+=getNum(i-1,1)+1;
                } else if (num[i]>x){
                    ans+=pow10(i-1);
                } else {
                    ans+=0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int a , b;
        while ((a=nextInt())!=0&&(b=nextInt())!=0){
            if(a>b){
                int t = a;
                a = b;
                b = t;
            }
            for(int i=0;i<=9;i++){
                out.print(work(b,i)-work(a-1,i)+" ");
            }
            out.println();
        }
        out.flush();
    }
}
