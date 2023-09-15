package BM;

import java.util.Scanner;

public class BM21_ReverserArray {
	public static int getMin(int[] arr){
		int l=0,r=arr.length-1;
		int mid=0;
		while (l<r){
			mid=l+r>>1;
			if(arr[mid]>arr[r])
				l=mid+1;
			else if(arr[mid]==arr[r])
				r--;
			else
				r=mid;
		}

		return arr[l];

	}

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		String[] strings=in.nextLine().split(" ");
		int[] arr=new int[strings.length];
		for(int i=0;i<arr.length;i++){
			arr[i]=Integer.parseInt(strings[i]);
		}


	}
}
