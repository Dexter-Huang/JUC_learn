package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac786_找第k大的数 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,k;

    static int findKth(int[] arr,int l,int r){
        if(l>=r)
            return arr[k];
        int i = l-1,j=r+1,midVal =arr[l+r>>1];
        while (i<j){
            while (arr[++i]<midVal);
            while (arr[--j]>midVal);
            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        if(k<=j)
            return findKth(arr,l,j);
        else{
            return findKth(arr,j+1,r);
        }

    }

    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = buffer[0];k=buffer[1]-1;
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        out.write(findKth(arr,0,n-1)+"\n");
        out.flush();in.close();out.close();
    }
}
