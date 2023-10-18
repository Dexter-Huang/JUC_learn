package Acwing.Ac828_模拟栈;

import java.io.*;
class Stack<T> {
    T[] arr;
    int top;

    public Stack() {
        this.top = -1;
        arr = (T[]) new Object[100005];
    }

    public void pop(){
        this.top--;
    }

    public void push(T t){
        this.top++;
        arr[this.top] = t;
    }

    public T query(){
        return arr[this.top];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }
}

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static String nextStr() throws IOException {
        st.nextToken();
        return st.sval;
    }

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n-->0){
            String command = nextStr();
            switch (command){
                case "empty":
                    out.println(stack.isEmpty()?"YES":"NO");
                    break;
                case "query":
                    out.println(stack.query());
                    break;
                case "push":
                    stack.push(nextInt());
                    break;
                case "pop":
                    stack.pop();
                    break;
                default:
                    break;
            }
        }
        out.flush();
    }
}
