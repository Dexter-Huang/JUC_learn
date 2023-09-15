package BM;

import java.util.HashMap;
import java.util.Scanner;
class sPair{
    int num;
    int index;

    public sPair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

public class BM50_twoSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] inputs = (in.nextLine()).split(" ");
        int target = Integer.parseInt(inputs[1]);
        String[] numsStr = inputs[0].split(",");
        int[] nums = new int[numsStr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            nums[i]=Integer.parseInt(numsStr[i]);
        }
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //将不包含target - numbers[i]，装入map中，包含的话直接返回下标
            if(map.containsKey(target - nums[i])){
//                return new int[]{map.get(target - nums[i])+1, i+1};
                System.out.println(map.get(target - nums[i])+1+" "+(i+1));
            }
            else
                map.put(nums[i], i);
        }




    }
}
