package algorithm;

import java.util.Scanner;

public class MergeSort {
	public static int[] tmp=new int[10000];

	public static void mergeSort(int[] arr,int l, int r){
		if(l>=r)
			return;
		int mid=l+r>>1;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);

		int k=0,i=l,j=mid+1;

		for(;i<=mid&&j<=r;){
			if(arr[i]<=arr[j])
				tmp[k++]=arr[i++];
			else
				tmp[k++]=arr[j++];
		}

		while (i<=mid)
			tmp[k++]=arr[i++];
		while (j<=r)
			tmp[k++]=arr[j++];

		for(i=l,k=0;i<=r;k++,i++)
			arr[i]=tmp[k];

	}

	public static int getReversedPairNum(int[] arr,int l, int r){
		if(l>=r)
			return 0;
		int mid=l+r>>1;
		int ans =getReversedPairNum(arr,l,mid)+ getReversedPairNum(arr,mid+1,r);
		int k=0,i=l,j=mid+1;

		while (i<=mid&&j<=r){
			if(arr[i]>arr[j]){
				ans+=(mid-i+1);
				tmp[k++]=arr[j++];
			}
			else{
				tmp[k++]=arr[i++];

			}
		}
		while (i<=mid)
			tmp[k++]=arr[i++];

		while (j<=r)
			tmp[k++]=arr[j++];


		for(i=l,k=0;i<=r;k++,i++)
			arr[i]=tmp[k];

		return ans;


	}

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);

		String[] strings = in.nextLine().split(",");
		int[] arr=new int[strings.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(strings[i]);

//		mergeSort(arr,0,arr.length-1);

//		Arrays.stream(arr).forEach(o-> System.out.print(o+" "));

		System.out.println(getReversedPairNum(arr,0,arr.length-1));
	}
}
