package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HJ9 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = new StringBuilder(in.readLine()).reverse().toString().toCharArray();

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i]))
                map.put(arr[i],i);
        }

        LinkedList<Map.Entry<Character,Integer>> list = new LinkedList<>();

        for (Map.Entry<Character, Integer> item :
                map.entrySet()) {
            list.add(item);
        }

        list.sort((o1, o2) -> o1.getValue()- o2.getValue());
        list.forEach(o1-> System.out.print(o1.getKey()));


    }
}
