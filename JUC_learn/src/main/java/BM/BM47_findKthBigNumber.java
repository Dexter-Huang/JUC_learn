package BM;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BM47_findKthBigNumber { //求第k大，不是第k小
    public static int findKthUsingQueue(int[] nums, int len, int k){
//        PriorityQueue<Integer> heap2 = new PriorityQueue<>(k,((o1, o2) -> o2-o1));// 大跟堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k); //小根堆
        for(int num:nums){
            if(heap.size()<k){
                heap.add(num);
            }
            else{
                if(num>heap.peek()){
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.isEmpty()?0:heap.peek();
    }

    public static int findKthBigUsingQuickSort(int[] nums, int left, int right,int k){
        if(left>right)
            return -1;
        int point = partition(nums,left,right);
        int left_cal = right-point+1;
        if(left_cal==k)
            return nums[point];
        else if(left_cal<k)
            return findKthBigUsingQuickSort(nums, left, point-1, k-left_cal);
        else
            return findKthBigUsingQuickSort(nums, point+1,right,k);
    }

    public static int partition(int[]arr, int left,int right){
        int first = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=first){
                right--;
            }
            swap(arr,left,right);
            while (left<right&&arr[left]<=first){
                left++;
            }
            swap(arr,left,right);
        }
        return left;
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int len = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int[] nums = new int[len];
        String[] numStr = line[0].split(",");
        for(int i=0;i< len;i++){
            nums[i]=Integer.parseInt(numStr[i]);
        }


//        System.out.println(findKthUsingQueue(nums,len,k));
        System.out.println(findKthBigUsingQuickSort(nums,0,nums.length-1,k));

    }
}
