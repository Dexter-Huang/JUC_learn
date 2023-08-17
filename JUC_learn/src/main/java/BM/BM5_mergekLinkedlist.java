package BM;

import java.util.ArrayList;
import java.util.Scanner;

public class BM5_mergekLinkedlist {
	public static ListNode mergeNoRecursive(ListNode list1,ListNode list2){
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;

		ListNode vhead = new ListNode(-1),cur=vhead;
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

		return vhead.next;
	}

	public static ListNode divideMerge(ArrayList<ListNode> lists,int left,int right){
		if(left>right)
			return null;
		else if(left == right)
			return lists.get(left);

		int mid = (left+right)/2;

		return mergeNoRecursive(divideMerge(lists,left,mid),divideMerge(lists,mid+1,right));
	}


	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		ArrayList<ListNode> lists=new ArrayList<>();
		int lineNum=in.nextInt();
		in.nextLine();
		ListNode vhead=new ListNode(-1),node=vhead;
		for (int i=0;i<lineNum;i++){
			String[] strs=in.nextLine().split(",");
			for(String str : strs){
				node.next=new ListNode(Integer.parseInt(str));
				node=node.next;
			}
			lists.add(vhead.next);
			node=vhead;
		}

		lists.stream().forEach(ListNode::printNode);
		System.out.println("============");

		ListNode.printNode(divideMerge(lists,0,lists.size()-1));
	}
}
