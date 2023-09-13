package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac785_快排 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static void quickSort(int[] arr, int l,int r){
        if(l>=r)
            return;
        int i = l-1,j=r+1,midVal=arr[l+r>>1];
        while (i<j){
            while (arr[++i]<midVal);
            while (arr[--j]>midVal);

            if(i<j)
            {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j]=tmp;
            }
        }

        quickSort(arr,l,j);
        quickSort(arr,j+1,r);
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(o-> {
            try {
                out.write(o + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        out.flush();in.close();out.close();
    }
}
