//https://leetcode.com/problems/merge-k-sorted-lists/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //heap solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            while (node != null) {
                q.offer(node);
                node = node.next;
            }
        }
        if (q.isEmpty()) {
            return null;
        }
        ListNode d = new ListNode();
        ListNode curr = d;
        while (!q.isEmpty()) {
            curr.next = q.poll();
            curr = curr.next;
            // in case of same val nodes in the end
            if (q.isEmpty()) {
                curr.next = null;
            }
        }
        return d.next;
    }
}

// non-heap solution
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists.length == 0) {
//             return null;
//         }
//         return split(lists, 0, lists.length - 1);
//     }
//     private ListNode split(ListNode[] lists, int l, int r) {
//         if (l == r) {
//             return lists[l];
//         }
//         int mid = (l + r)/2;
//         ListNode head1 = split(lists, l, mid);
//         ListNode head2 = split(lists, mid + 1, r);
//         return merge2(head1, head2);
//     }
//     private ListNode merge2(ListNode head1, ListNode head2) {
//         if (head1 == null) {
//             return head2;
//         }
//         if (head2 == null) {
//             return head1;
//         }
//         if (head1.val < head2.val) {
//             head1.next = merge2(head1.next, head2);
//             return head1;
//         } else {
//             head2.next = merge2(head1, head2.next);
//             return head2;
//         }
//     }
// }
