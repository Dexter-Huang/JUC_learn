package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ15 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        int tmp=0,ans=0;
        while (num!=0){
            tmp=num%2;
            if(tmp==1)
                ans++;
            num/=2;
        }
        System.out.println(ans);

    }
}
