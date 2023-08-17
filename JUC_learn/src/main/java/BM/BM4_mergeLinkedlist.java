package BM;

import java.util.Scanner;

class ListNode{
	int val;

	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public static ListNode generateList(String str){
		String[] strs=str.split(",");
		ListNode vhead = new ListNode(-1),cur=vhead;
		for(String s:strs){
			cur.next=new ListNode(Integer.parseInt(s));
			cur=cur.next;
		}

		return vhead.next;
	}

	public static void printNode(ListNode node) {
		System.out.print(node.val);
		node=node.next;

		while (node!=null){
			System.out.print("->"+node.val);
			node=node.next;
		}
		System.out.println();
	}

}

public class BM4_mergeLinkedlist {
	public static ListNode mergeRecursive(ListNode list1, ListNode list2){
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;

		if(list1.val<=list2.val){
			list1.next= mergeRecursive(list1.next,list2);
			return list1;
		}
		else{
			list2.next= mergeRecursive(list1,list2.next);
			return list2;
		}
	}

	public static ListNode mergeNoRecursive(ListNode list1,ListNode list2){
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;

		ListNode vHead = new ListNode(-1),cur=vHead;

		while (list1!=null&&list2!=null){
			if(list1.val<=list2.val){
				cur.next=list1;
				list1=list1.next;
			}
			else{
				cur.next=list2;
				list2=list2.next;
			}
			cur=cur.next;
		}

		if(list1!=null)
			cur.next=list1;

		if(list2!=null)
			cur.next=list2;

		return vHead.next;
	}


	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		String[] str1=in.nextLine().split(",");
		String[] str2=in.nextLine().split(",");

		ListNode node1=new ListNode(Integer.parseInt(str1[0]));
		ListNode node2=new ListNode(Integer.parseInt(str2[0]));
		ListNode tmp=null,cur=node1;
		for(int i=1;i<str1.length;i++){
			tmp=new ListNode(Integer.parseInt(str1[i]));
			cur.next=tmp;
			cur=cur.next;
		}

		cur=node2;tmp=null;
		for(int i=1;i<str2.length;i++){
			tmp=new ListNode(Integer.parseInt(str2[i]));
			cur.next=tmp;
			cur=cur.next;
		}

		ListNode.printNode(node1);
		ListNode.printNode(node2);

		ListNode.printNode(mergeNoRecursive(node1,node2));

	}
}
