package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HW23 {
     private static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null)
                queue.add(p.next);
        }
        return dummy.next;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        ListNode[] lists = new ListNode[n];
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(",");
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            for (int j = 0; j < s.length; j++) {
                p.next = new ListNode(Integer.parseInt(s[j]));
                p = p.next;
            }
            lists[i] = dummy.next;
        }

        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
