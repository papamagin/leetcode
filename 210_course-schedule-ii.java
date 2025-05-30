//https://leetcode.com/problems/course-schedule-ii/description/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }
        int[] states = new int[numCourses]; // 0 - unvisited, 1 - visiting, 2 - visited
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, states, res)) {
                return new int[0];
            }

        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    private boolean dfs(int source, Map<Integer, List<Integer>> graph, int[] states, List<Integer> res) {
        if (states[source] == 2) {
            return true; // "good" node, visited
        }
        if (states[source] == 1) {
            return false; // cycle detected
        }
        states[source] = 1;
        for (int v : graph.getOrDefault(source, List.of())) {
            if (!dfs(v, graph, states, res)) {
                return false;
            }
        }
        states[source] = 2;
        res.add(source);
        return true;
    }
}
