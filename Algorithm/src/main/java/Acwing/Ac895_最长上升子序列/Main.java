package Acwing.Ac895_最长上升子序列;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws Exception{
        st.nextToken();
        return (int)st.nval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int[] arr = new int[n];
        int[] f = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nextInt();
            f[i]=1;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    f[i]= Math.max(f[j] +1,f[i]);
                }
            }
            max = Math.max(max,f[i]);
        }
        System.out.println(max);
    }
}
