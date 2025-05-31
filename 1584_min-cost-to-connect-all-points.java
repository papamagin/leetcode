//https://leetcode.com/problems/min-cost-to-connect-all-points/description/

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int res = 0;
        int n = points.length;
        if (n == 1) {
            return res;
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] v = q.poll();
            int toPoint = v[1];
            if (visited[toPoint]) {
                continue;
            }
            res += v[0];
            visited[toPoint] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(points[toPoint][0] - points[i][0]) + Math.abs(points[toPoint][1] - points[i][1]);
                    q.offer(new int[]{distance, i});
                }
            }
        }
        return res;
    }
}
