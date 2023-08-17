package BM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BM54_2_threeNumSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int target = 0;
        if(num.length<3)
            return ans;

        Arrays.sort(num);

        int len = num.length-2;
        for(int i=0;i<len;i++){
            int left=i+1,right=num.length-1;
            while (left<right){
                if(num[left]+num[right]+num[i]==target){
                    ans.add(new ArrayList<>(Arrays.asList(num[i],num[left],num[right])));
                    left++;
                    right--;
                } else if (num[left] + num[right] + num[i] < target) {
                    left++;
                } else{
                    right--;
                }
            }
        }


        return new ArrayList<>(ans.stream().distinct().collect(Collectors.toList()));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(" ");
        int[]nums= Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        threeSum(nums).forEach(o->{
            System.out.println(o.toString());
        });

    }
}
