package BM;

import java.util.ArrayList;
import java.util.Scanner;

public class BM48_dataFlowMedian {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void insert(Integer num){
        if(list.size()==0){
            list.add(num);
        }
        else{
            for(int i=0;i<list.size();i++){
                if(num<= list.get(i))
                    list.add(i,num);
            }
        }
    }

    public static Double getMedian(){
        int len = list.size();
        if(len%2==0){
            double mid = (double) (list.get(len/2)+list.get(len/2-1))/2.0;
            return mid;
        }
        else{
            double mid =(double) (list.get(len/2));
            return mid;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(",");

        for(int i=0;i< nums.length;i++){
            list.add(Integer.parseInt(nums[i]));
            System.out.println(getMedian());
        }

    }
}
