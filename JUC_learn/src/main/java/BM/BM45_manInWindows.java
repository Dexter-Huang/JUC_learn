package BM;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class BM45_manInWindows {
    public static ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size<=num.length&&size!=0){
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for(int i =0;i<size;i++){
                while (!dq.isEmpty()&&num[dq.peekLast()]<num[i])
                    dq.pollLast();
                dq.add(i);
            }

            for(int i = size;i< num.length;i++){
                res.add(num[dq.peekFirst()]);
                while (!dq.isEmpty()&&dq.peekFirst()<(i-size+1))//容器头部的元素已经不属于当前窗口的边界
                    dq.pollFirst();
                while (!dq.isEmpty()&&num[dq.peekLast()]<num[i])//如果容器不为空，则让当前元素和容器的最后一个元素比较，
                    // 如果大于，则将容器的最后一个元素删除，然后继续讲当前元素和容器的最后一个元素比较
                    dq.pollLast();
                dq.add(i);
            }
            res.add(num[dq.pollFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String input= in.nextLine();
        int wsize=Integer.parseInt(input.split(" ")[1]);
        String[] strings = input.split(" ")[0].split(",");
        int[] nums = new int[strings.length];

        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(strings[i]);
        }

        maxInWindows(nums,wsize).forEach(o-> System.out.print(o+" "));
    }
}
