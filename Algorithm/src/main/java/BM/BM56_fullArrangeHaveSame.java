package BM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BM56_fullArrangeHaveSame {

    public static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public static void permute(int[]nums,LinkedList<Integer>list,Boolean[]vis){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i< nums.length;i++){
            if(vis[i])
                continue;
            if(i>0&&nums[i-1]==nums[i]&&!vis[i-1])
                continue;
            vis[i]=true;
            list.add(nums[i]);

            permute(nums,list,vis);

            vis[i]=false;
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] numsStr = in.nextLine().split(" ");
        int[] nums = Arrays.stream(numsStr).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);
        Boolean[] vis = new Boolean[nums.length];
        Arrays.fill(vis,false);

        LinkedList<Integer> list = new LinkedList<>();
        permute(nums,list,vis);

        res.forEach(o-> System.out.println(o.toString()));

    }
}
