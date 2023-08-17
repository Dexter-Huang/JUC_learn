package algorithm;

/**
 * input :
 * n l r
 * n numbers
 */
public class IntBinarySearch {

	public static int[] arr={0,1,2,3,3,3,3,4,5,6};



	public static int getLeftBound(int l,int r){
		int mid = 0;
		while (l<r){
			mid=l+r>>1;
			if(3<=arr[mid])
				r=mid;
			else
				l=mid+1;
		}
		return l;
	}

	public static int getRightBound(int l,int r){
		int mid=0;
		while (l<r){
			mid=l+r>>1;
			if(arr[mid]<=3)
				l=mid;
			else
				r=mid-1;
		}
		return l;
	}

	public static void main(String[] args) {
		System.out.println(getLeftBound(0,9));
		System.out.println(getRightBound(0,9));
	}
}
