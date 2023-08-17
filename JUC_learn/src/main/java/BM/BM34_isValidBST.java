package BM;

import java.util.*;
import java.util.function.BiConsumer;

public class BM34_isValidBST {

	public static TreeNode buildTree(String[] nums,int index,int len){
		if("#".equals(nums[index]))
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

	public static TreeNode readTree(){
		Scanner in =new Scanner(System.in);
		String[] nums=("0,"+in.nextLine()).split(",");
		TreeNode root = buildTree(nums,1,nums.length-1);
		return root;
	}

	public static void levelOrder(TreeNode root,List<List<Integer>> lists){
		if(root==null)
			return;
		Queue<TreeNode> q =new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()){
			int n = q.size();
			ArrayList<Integer> arr =new ArrayList<>();
			for(int i=0;i<n;i++){
				TreeNode cur = q.poll();
				if(cur.left!=null)
					q.add(cur.left);
				if(cur.right!=null)
					q.add(cur.right);
				arr.add(cur.val);
			}
			lists.add(arr);
		}
	}

	public static void printOrder(TreeNode root, BiConsumer<TreeNode,List<List<Integer>>> con){
		List<List<Integer> > lists = new ArrayList<>();
		con.accept(root, lists);
		lists.forEach(System.out::println);
	}

	public static int pre = Integer.MIN_VALUE;
	public static boolean isValid_BST(TreeNode root){
		if(root==null)
			return true;
		if(!isValid_BST(root))
			return false;
		if(root.val<pre)
			return false;
		pre=root.val;
		return isValid_BST(root.right);
	}



	public static void main(String[] args) {
//
		TreeNode root = readTree();

		printOrder(root,BM34_isValidBST::levelOrder);

	}
}
