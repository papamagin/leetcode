//https://leetcode.com/problems/k-closest-points-to-origin/description/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int dist1 = a[0] * a[0] + a[1] * a[1];
            int dist2 = b[0] * b[0] + b[1] * b[1];
            return dist2 - dist1;
        });
        for (int[] p : points) {
            q.offer(p);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}
