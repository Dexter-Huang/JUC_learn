package BM;

import java.util.Scanner;
import java.util.Stack;

public class BM44_isValid {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        Scanner in =new Scanner(System.in);
        String str = in.nextLine();

        for(int i=0;i<str.length();i++){
            if(stack.size()>0){
                if(str.charAt(i)==']'&&stack.peek()=='['){
                    stack.pop();
                    continue;
                }

                if(str.charAt(i)==')'&&stack.peek()=='('){
                    stack.pop();
                    continue;
                }


                if(str.charAt(i)=='}'&&stack.peek()=='{'){
                    stack.pop();
                    continue;
                }
            }

            stack.push(str.charAt(i));
        }

        System.out.println(stack.isEmpty());
    }
}
