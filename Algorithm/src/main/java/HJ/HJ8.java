package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HJ8 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(map.containsKey(arr[0]))
                map.put(arr[0],map.get(arr[0])+arr[1]);
            else 
                map.put(arr[0],arr[1]);
        }
        LinkedList<Map.Entry<Integer,Integer>> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> item :
                map.entrySet()) {
            list.add(item);
        }
        list.sort((o1, o2) -> o1.getKey()- o2.getKey());

        list.stream().forEach(o-> System.out.println(o.getKey()+" "+o.getValue()));
    }
}
