package Acwing.Ac104_选中位数_货仓选址;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);

    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        int mid = 0;
        if(n%2==1){
            mid = arr[(n-1)/2];
        } else{
            mid = (arr[n/2]+arr[n/2-1])/2;
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=Math.abs(mid-arr[i]);
        }
        System.out.println(sum);
    }
}
