package BM;

import java.util.Scanner;

public class BM19_findTop {
	public static int findTop1(int[] arr){
		int left = 0,right= arr.length-1,mid=0;
		while (left<right){
			mid=left+right+1>>1;
			if(arr[mid-1]<arr[mid])
				left=mid;
			else
				right=mid-1;
		}
		return left;
	}

	public static int findTop2(int[] arr){
		int left = 0,right= arr.length-1,mid=0;
		while (left<right){
			mid=left+right>>1;
			if(arr[mid]<arr[mid+1])
				left=mid+1;
			else
				right=mid;
		}
		return left;
	}

	public static int findTop3(int[] arr){
		int left = 0,right= arr.length-1,mid=0;
		while (left<right){
			mid=left+right>>1;
			if(arr[mid]>arr[mid+1])
				right=mid;
			else
				left=mid+1;
		}
		return left;
	}

	public static int findTop4(int[] arr){
		int left = 0,right= arr.length-1,mid=0;
		while (left<right){
			mid=left+right+1>>1;
			if(arr[mid-1]>arr[mid])
				right=mid-1;
			else
				left=mid;
		}
		return left;
	}





	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strings = in.nextLine().split(" ");
		int[] nums = new int[strings.length];
		for(int i=0;i<strings.length;i++){
			nums[i]=Integer.parseInt(strings[i]);
		}

		System.out.println(findTop1(nums));
		System.out.println(findTop2(nums));
		System.out.println(findTop3(nums));
		System.out.println(findTop4(nums));

	}
}
