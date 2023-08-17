package BM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BM55_FullArrangeNoSame {

    // 存所有排列的集合
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(num,list);
        return res;
    }

    public static void backTrack(int[] num, LinkedList<Integer> list){
        if(list.size()== num.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i< num.length;i++){
            if(list.contains(num[i]))
                continue;
            list.add(num[i]);
            backTrack(num,list);
            list.removeLast();
        }

    }

    public static ArrayList<ArrayList<Integer>> permute2(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();
        // 先对res中加入一个空的list，给第一次插入制造一个空间。
        res.add(list);
        // 整个循环的次数为num的元素个数
        for(int i = 0; i < num.length; i++){

            ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
            // 遍历此时的排列结果
            for(ArrayList<Integer> r:res){
                // 根据集合的大小，使用for循环在可插入的位置进行插入
                for(int j = 0; j < r.size()+1; j++){
                    // 在第j个位置插入
                    r.add(j,num[i]);
                    // 此时构成新的排列集合，可能是不完整的排列集合（例如：[1,2];[2,1]这类）
                    ArrayList<Integer> temp = new ArrayList<>(r);
                    // 放进去tmp临时集合中
                    tmp.add(temp);
                    // 将刚插入的数移除掉，为了将同样的这个插入不同的位置
                    r.remove(j);
                }
            }
            // 最后赋给res进行返回
            res = new ArrayList<>(tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String[] numsStr = in.nextLine().split(" ");
        int[] nums=new int[numsStr.length];
        for(int i=0;i< nums.length;i++){
            nums[i]=Integer.parseInt(numsStr[i]);
        }

        permute(nums);

        res.forEach(o-> System.out.println(
                o.toString()
        ));

    }
}
