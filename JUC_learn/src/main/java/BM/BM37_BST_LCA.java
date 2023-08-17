package BM;

import java.util.*;

public class BM37_BST_LCA {
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

	public static int lowestCommonAncestor (TreeNode root, int p, int q) {
		if(p>q){
			int t = p;
			p = q;
			q = t;
		}
		if(p <= root.val && root.val <= q)
			return root.val;
		else if(q<root.val)
			return lowestCommonAncestor(root.left,p,q);
		else
			return lowestCommonAncestor(root.right,p,q);
	}
	public static void main(String[] args) {
		TreeNode root =readTree();
		levelOrder(root);

		System.out.println();

	}
}
