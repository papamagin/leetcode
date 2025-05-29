//https://leetcode.com/problems/course-schedule/description/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
        int[] states = new int[numCourses]; // 0 - unvisited, 1 - visiting, 2 - visited
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, states)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr, Map<Integer, List<Integer>> graph, int[] states) {
        if (states[curr] == 1) {
            return false; // cycle found
        }
        if (states[curr] == 2) {
            return true; // checked already
        }
        states[curr] = 1;
        for (int v : graph.getOrDefault(curr, List.of())) {
            if (!dfs(v, graph, states)) {
                return false;
            }
        }
        states[curr] = 2;
        return true;
    }
}
