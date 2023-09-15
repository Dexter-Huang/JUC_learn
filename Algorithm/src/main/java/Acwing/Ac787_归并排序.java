package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac787_归并排序 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[]tmp;

    static int[]arr;

    static void mergeSort(int[]arr,int l,int r){
        if(l>=r)
            return;
        int mid=l+r>>1;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        int k = 0,i=l,j=mid+1;
        while (i<=mid&&j<=r){
            if(arr[i]<=arr[j])
                tmp[k++]=arr[i++];
            else
                tmp[k++]=arr[j++];
        }
        while (i<=mid)
            tmp[k++]=arr[i++];
        while (j<=r)
            tmp[k++]=arr[j++];

        System.arraycopy(tmp,0,arr,l,r-l+1);
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(in.readLine());
        arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tmp = new int[arr.length];

        mergeSort(arr,0,num-1);

        Arrays.stream(arr).forEach(o-> {
            try {
                out.write(o+" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        out.flush();in.close();out.close();
    }


}
