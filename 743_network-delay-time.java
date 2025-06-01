//https://leetcode.com/problems/network-delay-time/description/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int res = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] e : times) {
            graph.computeIfAbsent(e[0], key -> new ArrayList<>()).add(new int[] { e[1], e[2] });
        }
        Map<Integer, Integer> minPathTo = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // distance + vertex

        pq.offer(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int distance = edge[0];
            int vertex = edge[1];
            if (minPathTo.keySet().contains(vertex)) {
                continue;
            }
            res = Math.max(res, distance);
            minPathTo.put(vertex, distance);
            for (int[] e : graph.getOrDefault(vertex, List.of())) {
                if (!minPathTo.keySet().contains(e[0])) {
                    pq.offer(new int[] { e[1] + distance, e[0] });
                }
            }
        }

        return minPathTo.size() == n ? res : -1;
    }
}
