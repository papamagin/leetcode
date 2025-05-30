//https://leetcode.com/problems/clone-graph/description/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> clone = cloneNodes(node);
        clone.entrySet().stream().forEach(e -> {
            for (Node oldNeighbor : e.getKey().neighbors) {
                e.getValue().neighbors.add(clone.get(oldNeighbor));
            }
        });
        return clone.get(node);
    }
    private Map<Node, Node> cloneNodes(Node node) {
        Map<Node, Node> res = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            res.put(curr, new Node(curr.val));
            for (Node n : curr.neighbors) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    q.offer(n);
                }
            }
        }
        return res;
    }
}
