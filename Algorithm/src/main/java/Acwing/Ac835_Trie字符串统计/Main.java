package Acwing.Ac835_Trie字符串统计;

import java.io.*;
import java.util.LinkedList;

class Node{
    char val;
    LinkedList<Node> list;
    int cnt;

    public Node(char val) {
        this.val = val;
        this.list = new LinkedList<>();
    }
}
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static String nextStr() throws IOException {
        st.nextToken();
        return st.sval;
    }

    static Node root = new Node('!');

    static void insert(char[] str){
        Node cur  = root;
        for(int i=0;i<str.length;i++){
            boolean isFound = false;
            for(Node node:cur.list){
                if(node.val==str[i]){
                    cur = node;
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                Node tmp = new Node(str[i]);
                cur.list.add(tmp);
                cur = tmp;
            }
        }
        cur.cnt++;
    }

    static int query(char[] str){
        Node cur = root;
        for(int i=0;i<str.length;i++){
            boolean isFound = false;
            for(Node node : cur.list){
                if(node.val==str[i]){
                    cur = node;
                    isFound = true;
                    break;
                }
            }
            if(!isFound)
                return 0;
        }
        return cur.cnt;
    }
    public static void main(String[] args) throws IOException {
        int num = nextInt();
        while (num-->0){
            String command = nextStr();
            if("I".equals(command)){
                char[] arr = nextStr().toCharArray();
                insert(arr);
            }else{
                char[] arr = nextStr().toCharArray();
                System.out.println(query(arr));;
            }
        }
    }
}
