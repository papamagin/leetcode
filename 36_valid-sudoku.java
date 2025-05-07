//https://leetcode.com/problems/valid-sudoku/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!(board[i][j] == '.') && !rowSet.add(board[i][j])) {
                    return false;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            Set<Character> columnSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (!(board[i][j] == '.') && !columnSet.add(board[i][j])) {
                    return false;
                }
            }
        }

        int[][] corners = new int[][]{{0,0},{0,3},{0,6},
                                      {3,0},{3,3},{3,6},
                                      {6,0},{6,3},{6,6}};
        
        for (int[] c : corners) {
            Set<Character> cSet = new HashSet<>();
            for (int i = c[0]; i < c[0]+3; i++) {
                for (int j = c[1]; j < c[1]+3; j++) {
                    if (!(board[i][j] == '.') && !cSet.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
