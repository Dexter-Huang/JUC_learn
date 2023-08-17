package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ac789_整数二分查找 {
    static BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n= buffer[0],q = buffer[1];
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (q-- >0){
            int target = Integer.parseInt(in.readLine());
            int L = -1, R = arr.length;
            while (L+1!=R){
                int mid = L+R>>1;
                if(arr[mid]>=target)
                    R = mid;
                else
                    L = mid;
            }

            int ans1 = R;
            if(R>=arr.length||arr[R]!=target)
                System.out.println("-1 -1");
            else{
                L = R;R=arr.length;
                while (L+1!=R){
                    int mid = L+R>>1;
                    if(arr[mid]<=target)
                        L = mid;
                    else
                        R = mid;
                }
                int ans2 = L;
                System.out.println(ans1+" "+ans2);
            }
        }

    }
}
