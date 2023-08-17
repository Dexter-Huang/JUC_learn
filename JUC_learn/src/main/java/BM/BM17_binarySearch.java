package BM;

import java.util.Scanner;

public class BM17_binarySearch {
	public static int search(int[] nums, int target){
		int l=0,r=nums.length-1;
		while (l<=r){
			int mid = l+r>>1;
			if(nums[mid]==target)
				return mid;
			else if(target<nums[mid])
				r = mid-1;
			else if(nums[mid]<target)
				l = mid+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strNums = in.nextLine().split(" ");
		int[] nums = new int[strNums.length];
		for(int i= 0;i<strNums.length;i++){
			nums[i]=Integer.parseInt(strNums[i]);
		}

		int target = in.nextInt();
		System.out.println(search(nums,target));
	}
}
