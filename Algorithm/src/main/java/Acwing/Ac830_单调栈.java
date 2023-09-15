package Acwing;

import java.io.*;
import java.util.Stack;

public class Ac830_单调栈 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in =new StreamTokenizer(br);
    static int read() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static Stack<Integer> stack = new Stack<>();

    static int n;

    public static void main(String[] args) throws IOException {
        n =read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=read();
        }
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                out.print("-1 ");
                stack.push(arr[i]);
            }
            else{
                while (!stack.isEmpty()&&stack.peek()>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    out.print("-1 ");
                    stack.push(arr[i]);
                }else{
                    out.print(stack.peek()+" ");
                    stack.push(arr[i]);
                }
            }
        }


        out.flush();
    }

}
