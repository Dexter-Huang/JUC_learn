package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        String[] list = str.split(" ");
        String end = list[list.length-1];

        System.out.println(end.length());

    }
}
