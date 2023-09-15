package BM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BM54_1_twoNumSum {
    public static ArrayList<ArrayList<Integer>> twoSum(int[] num,int target){
        int i = 0,j= num.length-1;
        ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
        while (i<j){
            if(num[i]+num[j]==target){
                ans.add(new ArrayList<>(Arrays.asList(num[i],num[j])));
                i++;
                j--;
            }
            else if(num[i]+num[j]<target)
                i++;
            else if(num[i]+num[j]>target)
                j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        in.nextLine();
        String[] strings = in.nextLine().split(" ");
        int[]nums=Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
//        System.out.println(nums.toString());

        twoSum(nums,target).forEach(o->{
            System.out.println(o.toString());
        });


    }
}
