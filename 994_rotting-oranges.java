//https://leetcode.com/problems/rotting-oranges/description/

class Solution {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        while (!q.isEmpty()) {
            int s = q.size();
            res++;
            for (int i = 0; i < s; i++) {
                int[] curr = q.poll();
                int[][] offsets = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] o : offsets) {
                    int newI = curr[0] + o[0];
                    int newJ = curr[1] + o[1];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 2;
                        q.offer(new int[]{newI, newJ});
                        freshCount--;
                    }
                }
            }
        }

        return freshCount == 0 ? res - 1 : -1;
    }
}
