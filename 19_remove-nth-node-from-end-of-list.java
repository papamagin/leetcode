//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode l = head;
        ListNode r = head;
        //keep the distance of n
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        while (r != null) {
            r = r.next;
            prev = l;
            l = l.next;
        }

        if (prev == null) {
            return head.next;
        } else {
            prev.next = l.next;
        }
        return head;
    }
}
