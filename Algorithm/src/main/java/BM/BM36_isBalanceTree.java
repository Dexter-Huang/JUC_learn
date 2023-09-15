package BM;

import java.util.*;

public class BM36_isBalanceTree {
	public static TreeNode buildTree(String[] nums, int index,int len){
		if("#".equals(nums[index]))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(nums[index]));
		if(index*2<=len)
			root.left=buildTree(nums,index*2,len);
		else
			root.left=null;

		if(index*2+1<=len)
			root.right=buildTree(nums, index*2+1, len);
		else
			root.right=null;

		return root;
	}

	public static void levelOrder(TreeNode root){
		if(root==null)
			return;
		List<List<Integer>> lists = new ArrayList<>();
		Queue<TreeNode> q =  new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()){
			ArrayList<Integer> arr = new ArrayList<>();
			int n = q.size();
			for(int i=0;i<n;i++){
				TreeNode cur =q.poll();
				if(cur.left!=null)
					q.add(cur.left);
				if(cur.right!=null)
					q.add(cur.right);
				arr.add(cur.val);
			}
			lists.add(arr);
		}

		lists.forEach(System.out::println);
	}

	public static TreeNode readTree(){
		Scanner in =new Scanner(System.in);
		String[] nums=("0,"+in.nextLine()).split(",");
		TreeNode root= buildTree(nums,1,nums.length-1);
		return root;
	}

	public static int deep(TreeNode root){
		if(root==null)
			return 0;
		int left = deep(root.left);
		int right = deep(root.right);
		return Math.max(left,right)+1;
	}


	public static boolean isBalanceTree(TreeNode root){
		if(root==null)
			return true;
		int left = deep(root.left);
		int right = deep(root.right);
		if(Math.abs(left-right)>1)
			return false;
		return isBalanceTree(root.left)&&isBalanceTree(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = readTree();

		levelOrder(root);
	}
}
