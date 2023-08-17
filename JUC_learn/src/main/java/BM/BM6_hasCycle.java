package BM;

import java.util.Scanner;

public class BM6_hasCycle {
	public static boolean hasCycle(ListNode head){
		if(head==null||head.next==null)
			return false;

		ListNode fast = head,slow = head;
		while (fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				return true;
		}
		return false;

	}

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		String[] strings = in.nextLine().split(",");
		ListNode vhead = new ListNode(-1),cur=vhead;
		for(int i=0;i<strings.length;i++){
			cur.next=new ListNode(Integer.parseInt(strings[i]));
			cur=cur.next;
		}

		System.out.println(hasCycle(vhead.next));
	}
}
