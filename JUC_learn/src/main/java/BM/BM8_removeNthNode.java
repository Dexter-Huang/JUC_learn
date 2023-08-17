package BM;

import java.util.ArrayList;
import java.util.Scanner;

public class BM8_removeNthNode {
	public static ListNode generateList(String str){
		String[] strs=str.split(",");
		ListNode vhead = new ListNode(-1),cur=vhead;
		for(String s:strs){
			cur.next=new ListNode(Integer.parseInt(s));
			cur=cur.next;
		}

		return vhead.next;
	}

	public static ListNode getKthNodeFromTail(ListNode head,int k){
		if(k==0)
			return null;
		ListNode vhead = new ListNode(-1),cur=vhead;
		vhead.next=head;
		ArrayList<ListNode> arr = new ArrayList<>();
		while (cur!=null){
			arr.add(cur);
			cur=cur.next;
		}

		return arr.size()<k?null:arr.get(arr.size()-k);
	}
	public static ListNode removeKthNodeFromTail(ListNode head,int k){
		ListNode vhead= new ListNode(-1),cur=vhead;
		cur.next=head;
		ListNode preKNode = getKthNodeFromTail(cur,k+1);
		if(preKNode==null)
			return null;
		else{
			preKNode.next=preKNode.next.next;
		}
		return vhead.next;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ListNode head = generateList(in.nextLine());
		int k = in.nextInt();

		ListNode.printNode(removeKthNodeFromTail(head,k));


	}
}
