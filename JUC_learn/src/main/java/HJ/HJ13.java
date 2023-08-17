package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class HJ13 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = (ArrayList<String>) Arrays.stream(in.readLine().split(" ")).collect(Collectors.toList());
        Collections.reverse(arr);
        arr.forEach(o-> System.out.print(o+" "));



    }
}
