package BM;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BM51 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String[] nums = in.nextLine().split(",");
        int[] array = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            array[i]=Integer.parseInt(nums[i]);
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }
            else{
                map.put(array[i],1);
            }
        }

        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(entry.getValue()> array.length/2){
//                return entry.getKey();
                System.out.println(entry.getKey());
            }
        }

    }
}
