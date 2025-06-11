//https://leetcode.com/problems/lru-cache/description/?envType=problem-list-v2&envId=design

public class LRUCache {
    private final int capacity;
    private int size;
    private Node head; // LRU element is head.next
    private Node tail;
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = Math.max(capacity, 0);
        head = new Node(0, 0, null, null);
        tail = new Node(0, 0, head, null);
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            moveToTheTail(curr);
            return curr.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            throw new UnsupportedOperationException("capacity is 0");
        }
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            if (tail.prev == curr) {
                return;
            }
            moveToTheTail(curr);
        } else {
            if (size == capacity) {
                removeLRUelement();
            }
            Node curr = new Node(key, value, null, null);
            moveToTheTail(curr);
            map.put(key, curr);
            size++;
        }
    }

    private void moveToTheTail(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeLRUelement() {
        if (size == 0) {
            return;
        }
        Node toRemove = head.next;
        head.next = toRemove.next;
        toRemove.next.prev = head;
        map.remove(toRemove.key);
        size--;
    }

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
