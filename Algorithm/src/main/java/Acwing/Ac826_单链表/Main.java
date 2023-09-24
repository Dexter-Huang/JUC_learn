package Acwing.Ac826_单链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    static String nextStr() throws IOException {
        st.nextToken();
        return (String) st.sval;
    }

    static         int time = 0;
    static HashMap<Integer,ListNode> map = new HashMap<>();
    static ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
    static {
        map.put(0,fakeHead);
    }

    static void incr(ListNode node){
        time++;
        map.put(time,node);
    }

    static void printList(){
        ListNode cur = fakeHead;
        while ((cur=cur.next)!=null){
            System.out.print(cur.val+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for(int i=0;i<n;i++){
            String command = nextStr();
            switch (command){
                case "H":
                    ListNode futureHead = new ListNode(nextInt());
                    ListNode curHead = fakeHead.next;
                    fakeHead.next = futureHead;
                    futureHead.next = curHead;
                    incr(futureHead);
//                    printList();
                    break;
                case "I":
                    int k = nextInt(), x= nextInt();
                    ListNode curNode = new ListNode(x);
                    ListNode kthNode = map.get(k);
                    ListNode kNextNode = kthNode.next;

                    kthNode.next = curNode;
                    curNode.next=kNextNode;
                    incr(curNode);
//                    printList();

                    break;
                case "D":
                    int k2 = nextInt();
                    ListNode kthNode2 = map.get(k2);
                    if(kthNode2.next!=null){
                        kthNode2.next = kthNode2.next.next;
                    }
//                    printList();
                    break;
                default:
                    break;

            }
        }

        ListNode cur = fakeHead;
        while ((cur=cur.next)!=null){
            System.out.print(cur.val+" ");
        }
    }
}
