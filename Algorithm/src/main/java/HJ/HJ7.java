package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ7 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double a = Double.parseDouble(in.readLine());

        double end = a%1.0;

        if(end>=0.5)
            System.out.println((long)a+1L);
        else
            System.out.println((long)a);

//        System.out.println(end);
    }
}
