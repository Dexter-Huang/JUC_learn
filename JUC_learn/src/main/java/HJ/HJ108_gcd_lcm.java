package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ108_gcd_lcm {
    static int gcd(int p,int q){
        if(p==q)
            return p;
        if(p>q)
            return gcd(q,p-q);
        else{
            return gcd(p,q-p);
        }
    }

    static int lcm(int p,int q){
        return (p*q)/gcd(p,q);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(gcd(arr[0],arr[1]));
        System.out.println(lcm(arr[0],arr[1]));

        in.close();
    }
}
