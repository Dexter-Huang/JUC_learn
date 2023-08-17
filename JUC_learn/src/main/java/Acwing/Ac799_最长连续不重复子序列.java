package Acwing;

import java.io.*;
import java.util.Arrays;

public class Ac799_最长连续不重复子序列 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr = new int[100010];
    static int[] count = new int[100010];

    static int ans =0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        int[] tmp = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(tmp,0,arr,0,tmp.length);
        for (int i = 0,j=0; j < n; j++) {
            count[arr[j]]++;
            while (count[arr[j]]>1){
                count[arr[i]] --;
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }

        out.write(ans+"");



        out.flush();out.close();in.close();
    }
}
