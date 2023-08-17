package BM;

import java.io.*;
import java.util.Arrays;

public class BM97_旋转数组 {
    static BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);

    static int read() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    static int n,m;

    static void reverse(int[] arr,int start,int end){
        while (start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }

    public static void main(String[] args) throws IOException {
        n = read();m = read();
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reverse(arr,0,n-1);
        reverse(arr,0,m-1);
        reverse(arr,m,n-1);

        Arrays.stream(arr).forEach(o-> System.out.print(o+" "));

        out.flush();
    }
}
