package Acwing.Ac829_模拟队列;

import java.io.*;

class Queue{
    int[] arr;
    int head;
    int tail;

    public Queue() {
        this.arr = new int[100005];
        this.tail = -1;
        this.head = 0;
    }

    public void push(int val){
        tail++;
        this.arr[tail] = val;
    }

    public void pop(){
        this.arr[head]=0;
        head++;
    }

    public int query(){
        return this.arr[head];
    }

    public String isEmpty(){
        if(this.tail<this.head){
            return "YES";
        }else {
            return "NO";
        }
    }
}

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);
    static int nextInt() throws Exception{
        st.nextToken();
        return (int)st.nval;
    }
    static String nextStr() throws IOException {
        st.nextToken();
        return st.sval;
    }

    public static void main(String[] args) throws Exception {
        int num = nextInt();
        Queue queue = new Queue();
        while (num-->0){
            String command = nextStr();
            switch (command){
                case "push":
                    queue.push(nextInt());
                    break;
                case "empty":
                    out.println(queue.isEmpty());
                    break;
                case "query":
                    out.println(queue.query());
                    break;
                case "pop":
                    queue.pop();
                    break;
                default:
                    break;
            }

        }
        out.flush();

    }
}
