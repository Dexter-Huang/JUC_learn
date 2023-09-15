package BM;

import java.util.Scanner;

public class BM18_2dSearch {
	public static String Search2D(int target, int[][] arr){
		// 数组传参需要判断长度是否为0
		int row=arr.length==0?0:arr.length;
		int col=(row==0)||(arr[0].length==0)?0:arr[0].length;
		if(row==0||col==0)
			return "-1";

		for(int i=0,j=col-1;i<row&&j>=0;){
			if(arr[i][j]>target)
				j--;
			else if(arr[i][j]<target)
				i++;
			else
				return i+" "+j;
		}
		return "-1";

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt(), col=in.nextInt(),target=in.nextInt();
		in.nextLine();
		int[][] arr=new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				arr[i][j]=in.nextInt();
			}
			in.nextLine();
		}
		System.out.println(Search2D(target,arr));


	}
}
