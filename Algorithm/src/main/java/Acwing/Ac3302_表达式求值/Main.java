package Acwing.Ac3302_表达式求值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static char[] nextStr() throws IOException {
        return in.readLine().toCharArray();
    }
    static Stack<Character> synStack = new Stack<>();
    static Stack<Integer> numStack = new Stack<>();
    static char[] arr;
    static void priorityCal(char syn,int post){
        if(syn=='*'){
            numStack.push(numStack.pop()*post);
        } else if (syn == '/') {
            numStack.push(numStack.pop()/post);
        }
    }

    static void cal(){
        char syn;
        while (!synStack.isEmpty()&&(syn=synStack.pop())!='('){
            switch (syn){
                case '+':
                    numStack.push(numStack.pop()+numStack.pop());
                    break;
                case '-':
                    int a = numStack.pop(), b = numStack.pop();
                    numStack.push(b-a);
                    break;
//                case '*':
//                    numStack.push(numStack.pop()*numStack.pop());
//                    break;
//                case '/':
//                    int a1 = numStack.pop(), b1 = numStack.pop();
//                    numStack.push(b1/a1);
//                    break;
                default:
                    break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        arr = nextStr();
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
            if(Character.isDigit(arr[i])){
                numStack.push(Integer.parseInt(String.valueOf(arr[i])));
            } else if(arr[i]==')'){
                cal();
            } else if (arr[i]=='*'||arr[i]=='/') {
                priorityCal(arr[i],Integer.parseInt(String.valueOf(arr[++i])));
            } else{
                synStack.push(arr[i]);
            }
        }
        cal();
        System.out.println(numStack.pop());
    }
}
