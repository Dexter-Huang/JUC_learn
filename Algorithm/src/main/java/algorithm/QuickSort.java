package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

	public static void test(List<Integer> arr){
		arr.set(0,100);
	}

	public static void quickSort1_pivot_left(int[] arr, int l, int r){
		if(l>=r)
			return;

		int pos = partition1(arr,l,r);

		quickSort1_pivot_left(arr, l, pos);
		quickSort1_pivot_left(arr, pos+1, r);
	}

	public static void quickSort2_pivot_right(int[] arr, int l, int r){
		if(l>=r)
			return;
		int pos = partition2(arr,l,r);


		quickSort2_pivot_right(arr, l, pos-1);
		quickSort2_pivot_right(arr, pos, r);
	}

	public static void quickSort3_pivot_mid(int[]arr, int left,int right){
		if(left>=right)
			return;
		int pos = partition3(arr,left,right);
		quickSort3_pivot_mid(arr,left,pos);
		quickSort3_pivot_mid(arr,pos+1,right);

	}

	public static int partition1(int[] arr, int left, int right){
		int pivot=arr[left];
		left--;
		right++;

		while (left<right){
			while (arr[++left]<pivot);
			while (arr[--right]>pivot);

			if(left<right){
				swap(arr,left,right);
			}
		}

		return right;
	}

	public static int partition2(int[] arr, int left, int right){
		int pivot=arr[right];
		left--;
		right++;

		while (left<right){
			while (arr[++left]<pivot);
			while (arr[--right]>pivot);

			if(left<right){
				swap(arr,left,right);
			}
		}

		return left;
	}


	public static int partition3(int[] arr, int left, int right){
		int ra = (int)(left + Math.random() * (right - left + 1));
		int pivot=arr[ra];//or left+right>>1
		left--;
		right++;

		while (left<right){
			while (arr[++left]<pivot);
			while (arr[--right]>pivot);

			if(left<right){
				swap(arr,left,right);
			}
		}

		return right;
	}



	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n= in.nextInt();
		in.nextLine();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
		}
		int[] tmp = Arrays.copyOf(arr,n);

		quickSort3_pivot_mid(arr,0,arr.length-1);

		Arrays.stream(arr).forEach(o-> System.out.print(o+" "));
		System.out.println();
		Arrays.stream(tmp).forEach(o-> System.out.print(o+" "));

	}
}
