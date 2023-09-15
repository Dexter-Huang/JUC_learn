package BM;

import java.util.*;

public class BM35_isCompleteTree {

	public static TreeNode buildTree(String[] nums,int index,int len){
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

	public static TreeNode readTree(){
		Scanner in =new Scanner(System.in);
		String[] nums = ("0,"+in.nextLine()).split(",");
		TreeNode root = buildTree(nums,1,nums.length-1);
		return root;
	}

	public static void levelOrder(TreeNode root, List<List<Integer>> lists){
		if(root==null)
			return;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()){
			ArrayList<Integer> arr = new ArrayList<>();
			int n =q.size();
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

		lists.forEach(System.out::println);
	}

	public static boolean isCompleteTree(TreeNode root){
		// write code here
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode cur;
		boolean notComplete = false;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur == null){
				notComplete = true;
				continue;
			}

			if (notComplete)
				return false;
			queue.add(cur.left);
			queue.add(cur.right);
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode node = readTree();

		List<List<Integer>> lists = new ArrayList<>();

//		levelOrder(node,lists);
		System.out.println(isCompleteTree(node));

		Queue<Integer> b = new LinkedList<>();
		b.add(null);

//		Queue<Integer> a  = new ArrayDeque<>();
//		a.add(null);


	}
}
