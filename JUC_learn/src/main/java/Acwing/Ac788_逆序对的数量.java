package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac788_逆序对的数量 {
    static BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static long[] tmp;

    static long reversePairCal(long[]arr, int l, int r){
        if(l>=r)
            return 0;
        int mid = l+r>>1;
        long ans = reversePairCal(arr,l,mid)+reversePairCal(arr,mid+1,r);
        int i = l,j=mid+1,k=0;
        while (i<=mid&&j<=r){
            if(arr[i]<=arr[j]){
                tmp[k++]=arr[i++];
            }else{//arr[i]>arr[j]
                ans+=(mid-i+1);
                tmp[k++]=arr[j++];
            }
        }

        while (i<=mid){
            tmp[k++]=arr[i++];
        }

        while (j<=r){
            tmp[k++]=arr[j++];
        }

        System.arraycopy(tmp,0,arr,l,r-l+1);
        return ans;

    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(in.readLine());
        long[] arr = Arrays.stream(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        tmp = new long[arr.length];

        out.write(reversePairCal(arr,0,num-1)+"\n");


        out.flush();in.close();out.close();
    }
}
