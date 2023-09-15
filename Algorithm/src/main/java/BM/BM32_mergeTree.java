package BM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BM32_mergeTree {

	public static TreeNode mergeTrees(TreeNode t1,TreeNode t2){
		if(t1==null)
			return t2;
		if(t2==null)
			return t1;

		TreeNode head = new TreeNode(t1.val+t2.val);
		head.left = mergeTrees(t1.left,t2.left);
		head.right = mergeTrees(t1.right,t2.right);
		return head;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strArr = ("0,"+in.nextLine()).split(",");
		TreeNode root1=TreeNode.buildTree(strArr,1,strArr.length-1);

		strArr = ("0,"+in.nextLine()).split(",");
		TreeNode root2=TreeNode.buildTree(strArr,1,strArr.length-1);

		List<Integer> list = new ArrayList<>();

		TreeNode.inorder(list,mergeTrees(root1,root2));
		list.forEach(o-> System.out.print(o+" "));
		System.out.println();

//		Arrays.sort();

	}
}
