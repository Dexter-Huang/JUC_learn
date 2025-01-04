package Acwing.Ac3302_表达式求值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> numStack = new Stack<>();
    static Stack<Character> opStack = new Stack<>();
    static HashMap<Character,Integer> opMap = new HashMap<>();
    static {
        opMap.put('(',0);
        opMap.put('+',1);
        opMap.put('-',1);
        opMap.put('*',2);
        opMap.put('/',2);
    }
    public static void eval(){
        int a = numStack.pop(), b = numStack.pop();
        char op = opStack.pop();
        int r = 0;
        switch (op){
            case '+':
                numStack.push(b+a);break;
            case '-':
                numStack.push(b-a);break;
            case '*':
                numStack.push(b*a);break;
            case '/':
                numStack.push(b/a);break;
        }
    }

    public static void main(String[] args) throws IOException {
        char[] arr = in.readLine().toCharArray();
        for(int i=0;i<arr.length;i++){
            if(Character.isDigit(arr[i])){ // 判断是数字
                int ans = 0, j =i;
                while (j<arr.length&&Character.isDigit(arr[j])){
                    ans = ans *10 + arr[j] - '0';
                    j++;
                }
                numStack.push(ans);
                i = j-1;
            } else if(arr[i]=='('){  // 判断是 (
                opStack.push('(');
            } else if (arr[i] == ')') { // 判断是 )
                while (opStack.peek()!='('){
                    eval();
                }
                opStack.pop();
            } else {   // +-*/
//                System.out.println(arr[i]);
//                System.out.println(opStack.peek());
                while (
                        !opStack.isEmpty()
                                && opMap.get(opStack.peek())>=opMap.get(arr[i])
                )
                    eval();
                opStack.push(arr[i]);
            }
        }
        while (!opStack.isEmpty()){
            eval();
        }
        System.out.println(numStack.peek());


    }
}
