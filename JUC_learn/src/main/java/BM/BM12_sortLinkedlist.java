package BM;

import java.util.Scanner;

public class BM12_sortLinkedlist {
	public static ListNode generateList(String str){
		String[] strs=str.split(",");
		ListNode vhead = new ListNode(-1),cur=vhead;
		for(String s:strs){
			cur.next=new ListNode(Integer.parseInt(s));
			cur=cur.next;
		}

		return vhead.next;
	}

	public static ListNode merge(ListNode pHead1,ListNode pHead2){
		if(pHead1==null)
			return pHead2;
		if(pHead2==null)
			return pHead1;

		ListNode vhead = new ListNode(-1),cur=vhead;
		while (pHead1!=null&&pHead2!=null){
			if(pHead1.val<=pHead2.val){
				cur.next=pHead1;
				pHead1=pHead1.next;
			}
			else{
				cur.next=pHead2;
				pHead2=pHead2.next;
			}
			cur=cur.next;

		}

		if(pHead1!=null)
			cur.next=pHead1;
		else
			cur.next=pHead2;

		return vhead.next;

	}

	public static ListNode sortInList(ListNode head){
		if(head==null||head.next==null)
			return head;

		ListNode left=head, right=head.next.next;
		while (right!=null && right.next!=null){
			left=left.next;
			right=right.next.next;
		}
		ListNode mid = left.next;
		left.next=null;
		return merge(sortInList(head), sortInList(mid));
	}



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ListNode head = ListNode.generateList(in.nextLine());
		ListNode.printNode(sortInList(head));

	}
}
