https://leetcode.com/problems/rotate-image/description/

class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        if (l == 0) {
            return;
        }

        // transpose
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // then reflect it through the middle
        for(int i = 0; i < l; i++) {
            for (int j = 0; j < l/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][l - j - 1];
                matrix[i][l - j - 1] = temp;
            }
        }

        return;
    }
}
