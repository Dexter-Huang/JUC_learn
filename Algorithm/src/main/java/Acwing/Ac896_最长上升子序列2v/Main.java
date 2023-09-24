package Acwing.Ac896_最长上升子序列2v;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    static int getIndex(int[] arr, int target){
        // 找到第一个>=target的数字
        int L = -1,R=arr.length;
        while (L+1!=R){
            int mid = L+R>>1;
            if(arr[mid]>=target){
                R = mid;
            } else{
                L=mid;
            }
        }
        return R;
    }

    static int getIndex2(Stack<Integer> stack, int target){
        int L = -1, R =stack.size();
        while (L+1!=R){
            int mid = L+R>>1;
            if(stack.get(mid)>=target){
                R = mid;
            } else{
                L=mid;
            }
        }
        return R;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<n;i++){
            if(stack.peek()<arr[i]){
                stack.push(arr[i]);
            } else if (stack.peek() > arr[i]) {
                int index = getIndex2(stack,arr[i]);
                stack.set(index,arr[i]);
            }
        }

        System.out.println(stack.size());
    }
}
