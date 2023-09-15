package BM;

import java.util.*;

public class BM38_LCA {

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
	//是否找到o
	public static boolean flag = false;
	public static void dfs(TreeNode root,ArrayList<Integer> path,int o){
		if(flag||root==null)
			return;
		path.add(root.val);
		if(root.val==o){
			flag=true;
			return;
		}
	}

	public static int lca(TreeNode root,int o1,int o2){
		ArrayList<Integer> path1=new ArrayList<>();
		ArrayList<Integer> path2=new ArrayList<>();

		dfs(root,path1,o1);

		flag=false;
		dfs(root,path2,o2);
		int res=0;
		for(int i =0;i<path1.size()&&i<path2.size();i++){
			if(path1.get(i)==path2.get(i))
				res++;
			else
				break;
		}
		return res;


	}

	public static void main(String[] args) {

		TreeNode root = readTree();
		System.out.println(lca(root,5,9));

	}
}
