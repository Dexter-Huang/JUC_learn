package BM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BM46_findKSmallNumber {

//    public static ArrayList<Integer> heapMethod(){
//
//    }
    public static void swap(int[]input,int i,int j){
        int temp = input[i];
        input[i]=input[j];
        input[j]=temp;
    }

    public static int partition(int[]input,int l,int r){
        int pivot=input[r-1];
        int i = l;
        for(int j=l;i<r-1;j++){
            if(input[j]<pivot)
            {
                swap(input,i,j);
                i++;
            }
        }
        swap(input,i,r-1);
        return i;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        if(k==0||k<input.length)
            return ans;
        int l = 0, r = input.length;
        while ( l < r){
            int p =partition(input,l,r);
            if(p+1==k){
                ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(input).boxed().collect(Collectors.toList());
                return (ArrayList<Integer>)list.subList(0,k);
            }
            if(p+1<k){
                l=p+1;
            }
            else{
                r = p;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int k =in.nextInt();
        in.nextLine();
        String[] strings = in.nextLine().split(",");
//        List<Integer> nums = Arrays.stream(strings)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
        int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        GetLeastNumbers_Solution(nums,3).forEach(o-> System.out.print(o+" "));




    }
}
