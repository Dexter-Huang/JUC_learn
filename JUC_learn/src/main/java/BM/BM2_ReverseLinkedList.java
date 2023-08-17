package BM;

import java.util.Scanner;


public class BM2_ReverseLinkedList {

	public static void reverse(ListNode beginNode){
		ListNode pre=null,temp=null,cur=beginNode;
		while(cur!=null){
			temp=cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
	}

	public static ListNode reversePartition(ListNode head,int m,int n){
		ListNode firstNode = new ListNode(-1);
		firstNode.next=head;

		ListNode nodepreM=null,nodeaftN=null, nodeM=null,nodeN=null,cur=firstNode;
		for(int i=0;i<n;i++){
			if(i==m-1){
				nodepreM=cur;
				nodeM=cur.next;
			}
			cur=cur.next;
		}

		nodeN=cur;
		nodeaftN=cur.next;

		nodepreM.next=null;
		nodeN.next=null;

		reverse(nodeM);

		nodepreM.next=nodeN;
		nodeM.next=nodeaftN;

		return firstNode.next;

	}



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strings=in.nextLine().split(",");
		int m=in.nextInt(),n=in.nextInt();
		ListNode node = null,preNode=new ListNode(Integer.parseInt(strings[0])),head=preNode;
		for(int i=1;i<strings.length;i++){
			node=new ListNode(Integer.parseInt(strings[i]));
			preNode.next=node;
			preNode=node;
		}

		ListNode.printNode(reversePartition(head,m,n));
	}
}
