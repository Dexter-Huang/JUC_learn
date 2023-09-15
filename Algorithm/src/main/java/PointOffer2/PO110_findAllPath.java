package PointOffer2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PO110_findAllPath {
    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public static void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }


    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        allPathsSourceTarget(graph).forEach(System.out::println);

    }
}
