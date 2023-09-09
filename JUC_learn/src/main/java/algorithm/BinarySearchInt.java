package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * int L=-1,R=n;
 * while(L+1!=R)
 * {
 * 	int mid=L+R>>1;
 * 	if(check()) L=mid;
 * 	else R=mid;
 * 	//最后根据你所分左右两边区间的结果
 * 	//选取L或者R作为结果
 * }
 */
public class BinarySearchInt {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static void test(int target,int [] arr,int n){
        int L = -1, R = n;
        while (L + 1 != R) {
            int mid = L + R >> 1;
            if (arr[mid] > target) {
                R = mid;
            } else {
                L = mid;
            }
        }
        System.out.println("arr[mid] > target"+":"+L+" "+R);
    }

    static void test2(int target,int [] arr,int n){
        int L = -1, R = n;
        while (L + 1 != R) {
            int mid = L + R >> 1;
            if (arr[mid] >= target) {
                R = mid;
            } else {
                L = mid;
            }
        }
        System.out.println("arr[mid] >= target"+":"+L+" "+R);
    }

    static void test3(int target,int [] arr,int n){
        int L = -1, R = n;
        while (L + 1 != R) {
            int mid = L + R >> 1;
            if (arr[mid] < target) {
                L = mid;
            } else {
                R = mid;
            }
        }
        System.out.println("arr[mid] < target"+":"+L+" "+R);
    }

    static void test4(int target,int [] arr,int n){
        int L = -1, R = n;
        while (L + 1 != R) {
            int mid = L + R >> 1;
            if (arr[mid] <= target) {
                L = mid;
            } else {
                R = mid;
            }
        }
        System.out.println("arr[mid] <= target"+":"+L+" "+R);
    }

    public static void main(String[] args) throws IOException {
        int n,q;
        int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = buffer[0];
        q = buffer[1];

        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (q-- > 0) {
            int L = -1, R = n;
            int target = Integer.parseInt(in.readLine());
            test(target,arr,n);
            test2(target,arr,n);
            test3(target,arr,n);
            test4(target,arr,n);
        }

    }
}
