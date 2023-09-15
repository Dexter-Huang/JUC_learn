package hot100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Pair{
    int num;
    int index;

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

public class HT1 {
    public static int[] twoSum_list(int[] nums, int target) {
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(new Pair(nums[i],i));
        }

        list.sort((o1, o2) -> o1.num-o2.num);

        for(int i=0,j=list.size()-1;i<j;){
            int cur =list.get(i).num+list.get(j).num;
            if(cur==target)
                return new int[]{list.get(i).index,list.get(j).index};
            else if (cur<target) {
                i++;
            }
            else {
                j--;
            }
        }
        return new int[]{};
    }

    public static int[] twoSum_arrays(int[] nums,int target){
        Pair[] list = new Pair[nums.length];
        for(int i=0;i< nums.length;i++){
            list[i]=new Pair(nums[i],i);
        }

        Arrays.sort(list, (o1,o2)->{return o1.num- o2.num;});

        for(int i=0,j= list.length-1;i<j;){
            int ans = list[i].num+list[j].num;
            if(ans == target)
                return new int[]{list[i].index,list[j].index};
            else if (ans<target) {
                i++;
            }
            else{
                j--;
            }
        }

        return new int[]{};


    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(twoSum_list(arr, target)).forEach(System.out::println);

    }
}
