//https://leetcode.com/problems/word-search/description/

class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        if (n == 1 && m == 1 && word.length() == 1) {
            return board[0][0] == word.charAt(0);
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(i, j, board, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(int i, int j, char[][] board, String word, int pos, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(pos) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = backtrack(i - 1, j, board, word, pos + 1, visited) 
                      || backtrack(i + 1, j, board, word, pos + 1, visited)
                      || backtrack(i, j - 1, board, word, pos + 1, visited) 
                      || backtrack(i, j + 1, board, word, pos + 1, visited);
        visited[i][j] = false;
        return res;
    }
}
