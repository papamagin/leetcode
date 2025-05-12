//https://leetcode.com/problems/copy-list-with-random-pointer/description/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node curr = head;
        Node dummy = new Node(0);
        Node prev = dummy;
        Map<Node, Node> copy = new HashMap<>();
        while (curr != null) {
            Node node = new Node(curr.val);
            prev.next = node;
            copy.put(curr, node);
            prev = node;
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node copyNode = copy.get(curr);
            copyNode.random = curr.random == null ? null : copy.get(curr.random);
            curr = curr.next;
        }
        return dummy.next;
    }
}
