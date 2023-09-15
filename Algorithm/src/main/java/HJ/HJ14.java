package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class HJ14 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.readLine());
        }
        list.sort((o1, o2) -> o1.compareTo(o2));

        list.forEach(System.out::println);
    }
}
