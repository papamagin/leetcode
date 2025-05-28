//https://leetcode.com/problems/max-area-of-island/description/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(i, j, grid));
                }
            }
        }
        return res;
    }
    private int bfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int res = 1;
        grid[i][j] = 0;
        return res + bfs(i - 1, j, grid) + bfs(i + 1, j, grid) + bfs(i, j - 1, grid) + bfs(i, j + 1, grid);
    }
}
