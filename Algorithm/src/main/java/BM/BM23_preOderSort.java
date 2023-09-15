package BM;

import java.util.*;
import java.util.function.BiConsumer;

class Pair{
	TreeNode node = null;
	int curSum = 0;

	public Pair(TreeNode node, int curSum) {
		this.node = node;
		this.curSum = curSum;
	}
}

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.val = val;
	}

	public static TreeNode readTree(){
		Scanner in =new Scanner(System.in);
		String[] nums = ("0,"+in.nextLine()).split(",");
		TreeNode root = buildTree(nums,1,nums.length-1);
		return root;
	}

	public static TreeNode buildTree(String[] nums, int index, int len){
		if(nums[index].equals("#"))
			return null;
		TreeNode root= new TreeNode(Integer.parseInt(nums[index]));

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

	public static void inorder(List<Integer> list,TreeNode root){
		if(root==null)
			return;
		inorder(list,root.left);
		list.add(root.val);
		inorder(list,root.right);
	}


	public static void preorder(List<Integer> list,TreeNode root){
		if(root==null)
			return;
		list.add(root.val);
		preorder(list,root.left);
		preorder(list,root.right);
	}

	public static void printOrder(TreeNode root, BiConsumer<List<Integer>,TreeNode > con){
		List<Integer> list=new ArrayList<>();
		con.accept(list,root);
		list.forEach(o-> System.out.print(o+" "));
		System.out.println();
	}

	public static void postorder(List<Integer> list,TreeNode root){
		if(root==null)
			return;
		postorder(list,root.left);
		postorder(list,root.right);
		list.add(root.val);
	}

	public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
		// write code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root==null)
			return res;
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
		return res;
	}

	public static int maxDepthRecursive (TreeNode root) {
		// write code here
		if(root==null)
			return 0;

		return Math.max(maxDepthRecursive(root.left),maxDepthRecursive(root.right))+1;

	}

	public static int maxDepthNoRecursive (TreeNode root) {
		// write code here
		if(root==null)
			return 0;

		Queue<TreeNode> q=new ArrayDeque<>();
		q.add(root);
		int res =0;
		while (!q.isEmpty()){
			int n = q.size();
			for(int i=0;i<n;i++){
				TreeNode node = q.poll();
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
			res++;
		}

		return res;
	}

	public static boolean hashPathSumDFSNoRecursive(TreeNode root,int targetSum){
		if(root==null)
			return false;
		Stack<Pair> s1 = new Stack<>();
		s1.add(new Pair(root,root.val));
		while (!s1.isEmpty()){
			Pair tmp = s1.pop();
			TreeNode node =tmp.node;
			int curSum = tmp.curSum;
			if(node.left==null&&node.right==null&&curSum==targetSum)
				return true;
			if(node.left!=null)
				s1.push(new Pair(node.left,curSum+node.left.val));
			if(node.right!=null)
				s1.push(new Pair(node.right,curSum+node.right.val));

		}
		return false;
	}

	public static TreeNode searchTreeToDeQue(TreeNode root){


		return null;
	}

	public static boolean isSymmetric(TreeNode root1,TreeNode root2){
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null||root1.val!=root2.val)
			return false;
		return isSymmetric(root1.left,root2.right)&&isSymmetric(root1.right,root2.left);
	}

}



public class BM23_preOderSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strArr = ("0,"+in.nextLine()).split(",");
		TreeNode root=TreeNode.buildTree(strArr,1,strArr.length-1);

		System.out.println("层序遍历");
		ArrayList<ArrayList<Integer>> lists=TreeNode.levelOrder(root);
		lists.stream().forEach(System.out::println);
		//
		System.out.println("前序遍历");
		TreeNode.printOrder(root,TreeNode::preorder);
		System.out.println("中序遍历");
		TreeNode.printOrder(root,TreeNode::inorder);
		System.out.println("后序遍历");
		TreeNode.printOrder(root,TreeNode::postorder);



	}
}
