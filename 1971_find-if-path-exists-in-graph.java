//https://leetcode.com/problems/find-if-path-exists-in-graph/description/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        return dfs(source, destination, graph, visited);
    }
    boolean dfs(int current, int destination, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (current == destination) {
            return true;
        }
        for (int v : graph.getOrDefault(current, List.of())) {
            if (!visited.contains(v)) {
                visited.add(v);
                if (dfs(v, destination, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         if (source == destination) {
//             return true;
//         }
//         Map<Integer, List<Integer>> graph = new HashMap<>();
//         for (int[] edge : edges) {
//             graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
//             graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
//         }
//         Set<Integer> visited = new HashSet<>();
//         Deque<Integer> dq = new LinkedList<>();
//         dq.addFirst(source);
//         visited.add(source);
//         while (!dq.isEmpty()) {
//             int curr = dq.removeFirst();
//             if (curr == destination) {
//                 return true;
//             }
//             for (int i : graph.getOrDefault(curr, List.of())) {
//                 if (!visited.contains(i)) {
//                     dq.addFirst(i);
//                     visited.add(i);
//                 }
//             }
//         }
//         return false;
//     }
// }

