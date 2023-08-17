package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class HW112 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static void dfs(TreeNode root,int target,int curVal,LinkedList<Integer> path){
        if(root == null){
            return;
        }
        curVal += root.val;
        path.add(root.val);
        if(curVal == target && root.left == null && root.right == null){
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i)+" ");
            }
            System.out.println();
        }
        dfs(root.left,target,curVal,path);
        dfs(root.right,target,curVal,path);
        path.removeLast();
    }

    static TreeNode buildTree(int[] arr){//层级建树
        TreeNode root = new TreeNode(arr[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(i<arr.length){
                if(arr[i] != -1){
                    cur.left = new TreeNode(arr[i]);
                    queue.add(cur.left);
                }
                i++;
            }
            if(i<arr.length){
                if(arr[i]!= -1){
                    cur.right = new TreeNode(arr[i]);
                    queue.add(cur.right);
                }
                i++;
            }
        }
        return root;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(in.readLine());

        int[] arr = Arrays.stream(in.readLine().split(","))
                .mapToInt(o->(o.equals("null"))?-1:Integer.parseInt(o))
                .toArray();


        TreeNode root = buildTree(arr);

        dfs(root,target,0,new LinkedList<>());


    }
}
