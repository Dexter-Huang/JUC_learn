package BM;

import java.util.*;
import java.util.function.BiConsumer;

public class BM33_mirrorTree {
	public static TreeNode getMirrorTree(TreeNode root){
		if(root==null)
			return null;
		TreeNode left = getMirrorTree(root.left);
		TreeNode right= getMirrorTree(root.right);

		root.left=right;
		root.right=left;
		return root;
	}

	public static TreeNode buildTree(String[] nums,int index,int len){
		if("#".equals(nums[index]))
			return null;
		TreeNode root=new TreeNode(Integer.parseInt(nums[index]));

		if(index*2<=len)
			root.left=buildTree(nums,index*2,len);
		else
			root.left=null;

		if(index*2+1<=len)
			root.right=buildTree(nums,index*2+1,len);
		else
			root.right=null;

		return root;
	}

	public static TreeNode readTree(){
		Scanner in =new Scanner(System.in);
		String[]nums=("0,"+in.nextLine()).split(",");
		TreeNode root=buildTree(nums,1,nums.length-1);
		return root;
	}

	public static void preorder(List<Integer> list,TreeNode root){
		if(root==null)
			return;
		list.add(root.val);
		preorder(list,root.left);
		preorder(list,root.right);
	}

	public static void inorder(List<Integer> list,TreeNode root){
		if(root==null)
			return;
		inorder(list,root.left);
		list.add(root.val);
		inorder(list,root.right);
	}

	public static void postorder(List<Integer> list,TreeNode root){
		if(root==null)
			return;
		postorder(list,root.left);
		postorder(list,root.right);
		list.add(root.val);
	}

	public static void printOrder(TreeNode root, BiConsumer<List<Integer>,TreeNode> con){
		List<Integer> list =  new ArrayList<>();
		con.accept(list,root);

		list.forEach(o-> System.out.print(o+" "));
		System.out.println();
	}

	public static void printOrder(TreeNode root, BiConsumer<List<List<Integer>>,TreeNode> con, String levelOrderMark){
		List<List<Integer>> list =  new ArrayList<>();
		con.accept(list,root);
		list.forEach(o-> System.out.println(o+" "));
		System.out.println();
	}

	public static void  levelOrder (List<List<Integer>> res,TreeNode root) {
		// write code here
		if(root==null)
			return ;
		Queue<TreeNode> q =new ArrayDeque<>();
		q.add(root);

		while (!q.isEmpty()){
			int n = q.size();
			ArrayList<Integer> row = new ArrayList<>();
			for(int i=0;i<n;i++){
				TreeNode cur = q.poll();
				if(cur.left!=null)
					q.add(cur.left);
				if(cur.right!=null)
					q.add(cur.right);
				row.add(cur.val);
			}
			res.add(row);
		}

	}

	public static TreeNode mirror(TreeNode root){
		if(root==null)
			return null;
		TreeNode left=mirror(root.left);
		TreeNode right=mirror(root.right);
		root.left=right;
		root.right=left;
		return root;
	}

	public static void main(String[] args) {
		TreeNode root=readTree();

		System.out.println("层序遍历");

		printOrder(root, BM33_mirrorTree::levelOrder,"hh");
		System.out.println("================");
		TreeNode mirrorTree=mirror(root);

		printOrder(mirrorTree, BM33_mirrorTree::levelOrder,"hh");


	}

}
