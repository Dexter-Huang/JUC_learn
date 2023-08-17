package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] target = in.readLine().toLowerCase().toCharArray();
        char cc = in.readLine().toLowerCase().charAt(0);
        int ans=0;
        for (int i = 0; i < target.length; i++) {
            if(cc==target[i])
                ans++;
        }
        System.out.println(ans);

    }
}
