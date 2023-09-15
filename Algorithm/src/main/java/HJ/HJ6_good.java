package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ6_good {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(in.readLine());
        long len = (long)Math.sqrt(t);
        for (long i = 2; i <= len; i++) {
            while(t%i==0){
                System.out.print(i+" ");
                t/=i;
            }
        }

        if(t!=1)
            System.out.print(t);
    }
}
