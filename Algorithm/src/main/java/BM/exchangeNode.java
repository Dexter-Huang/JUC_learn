package BM;

import java.util.ArrayList;
import java.util.Scanner;

public class exchangeNode {

    public static ListNode generateList(String str){
        String[] strings = str.split(",");
        ListNode vhead = new ListNode(-1),cur = vhead;
        for(String s :strings){
            cur.next=new ListNode(Integer.parseInt(s));
            cur=cur.next;
        }
        return vhead.next;
    }


    public static void printNode(ListNode head){
        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }

    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str = in.nextLine();
        ListNode head = generateList(str),cur = head,ansHead = null;
        if(head!=null){
            ansHead=head.next;
        }

        ListNode singleNode = null;

        ArrayList<ListNode> list = new ArrayList<>();
        while (cur!=null){
            if(cur.next==null){
                singleNode=cur;
                break;
            }

            ListNode nextNode=cur.next.next;
            cur.next.next=null;
            list.add(cur);
            cur=nextNode;
        }

//        list.stream().forEach(o-> System.out.print(o.val+" "));
//        System.out.println();
        int len =list.size()-1;
        for(int i=0;i<=len;i++){
            ListNode first = list.get(i),second = first.next;
            second.next=first;
            first.next=null;
            list.set(i,second);
        }
//        list.stream().forEach(o-> System.out.print(o.val+" "));

        for(int i=0;i<len;i++){
            ListNode first = list.get(i),second = first.next;
            second.next=list.get(i+1);
        }

        list.get(len).next.next=singleNode;

        printNode(ansHead);


    }
}
