import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        for (Map.Entry<Integer,Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }

    }
}
