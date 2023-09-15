package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ11 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = new StringBuilder(in.readLine()).reverse().toString();;
        System.out.println(str);
    }
}
