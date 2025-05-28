// https://leetcode.com/problems/number-of-islands/description
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(i, j, grid);
                }
            }
        }
        return res;
    }
    private void bfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        bfs(i - 1, j, grid);
        bfs(i + 1, j, grid);
        bfs(i, j - 1, grid);
        bfs(i, j + 1, grid);
    }
}
