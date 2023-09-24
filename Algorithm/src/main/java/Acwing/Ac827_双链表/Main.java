package Acwing.Ac827_双链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

class ListNode{
    int val;
    ListNode pre;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
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

    static HashMap<Integer,ListNode> map = new HashMap<>();
    static ListNode fakeHead = new ListNode(Integer.MIN_VALUE), fakeTail = new ListNode(Integer.MAX_VALUE);
    static int time = 0;
    static {
        fakeHead.next = fakeTail;
        fakeTail.pre = fakeHead;
    }

    static void incr(ListNode node){
        time++;
        map.put(time,node);
    }

    static void printList(){
        ListNode cur = fakeHead;
        while ((cur = cur.next)!=fakeTail){
            System.out.print(cur.val+" ");
        }
        System.out.println();
    }

    static void addNode(ListNode pre,ListNode cur,ListNode next){
        pre.next = cur;
        cur.next = next;
        next.pre = cur;
        cur.pre = pre;
    }

    static void delNode(ListNode pre,ListNode cur,ListNode next){
        pre.next = next;
        next.pre = pre;
        cur.next = null;
        cur.pre = null;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for(int i=0;i<n;i++){
            String target = nextStr();
            int x,k;
            switch (target){
                case "L":
                    x = nextInt();
                    ListNode curHead = fakeHead.next;
                    ListNode futureHead = new ListNode(x);
                    addNode(fakeHead,futureHead,curHead);
                    incr(futureHead);
                    break;
                case "R":
                    x = nextInt();
                    ListNode curTail = fakeTail.pre;
                    ListNode futureTail = new ListNode(x);
                    addNode(curTail,futureTail,fakeTail);
                    incr(futureTail);
                    break;
                case "D":
                    k = nextInt();
                    ListNode toDelNode = map.get(k);
                    ListNode preNode = toDelNode.pre;
                    ListNode nextNode = toDelNode.next;
                    delNode(preNode,toDelNode,nextNode);
                    break;
                case "IL":
                    k = nextInt();x=nextInt();
                    ListNode kthNode = map.get(k);
                    ListNode kthPreNode = kthNode.pre;
                    ListNode toAddNode = new ListNode(x);
                    addNode(kthPreNode,toAddNode,kthNode);
                    incr(toAddNode);
                    break;
                case "IR":
                    k = nextInt();x=nextInt();
                    ListNode kthNode2 = map.get(k);
                    ListNode kthAftNode2 = kthNode2.next;
                    ListNode toAddNode2 = new ListNode(x);
                    addNode(kthNode2,toAddNode2,kthAftNode2);
                    incr(toAddNode2);
                    break;
                default:
                    break;
            }
        }
        printList();

    }


}
