//https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        
        int[] leftCorner = new int[]{0,0};
        int[] rightCorner = new int[]{matrix.length-1, matrix[0].length-1};

        while (leftCorner[0] <= rightCorner[0] && leftCorner[1] <= rightCorner[1]) {
            iteration(matrix, leftCorner, rightCorner, res);

            //update the area
            leftCorner[0] = leftCorner[0]+1;
            leftCorner[1] = leftCorner[1]+1;
            rightCorner[0] = rightCorner[0]-1;
            rightCorner[1] = rightCorner[1]-1;
        }

        return res;
    }

    private void iteration(int[][] matrix, int[] leftCorter, int[] rightCorner, List<Integer> res) {
        // | (i,j) → → → → →|
        // | ↑ *  *  *  *  ↓|
        // | ↑ *  *  *  *  ↓|
        // | ↑ *  *  *  *  ↓|
        // | ↑ ← ← ← ← (n,m)|

        int i = leftCorter[0];
        int j = leftCorter[1];
        int n = rightCorner[0];
        int m = rightCorner[1]; 
        if (i == n) { // one-row area
            for (int k = j; k <= m; k++) {
                res.add(matrix[i][k]);
            }
        } else if (j == m) { // one-column area
            for (int k = i; k <= n; k++) {
                res.add(matrix[k][j]);
            }
        } else { // default area
            for (int k = j; k <= m; k++) {
                res.add(matrix[i][k]);
            }
            for (int k = i+1; k <= n; k++) {
                res.add(matrix[k][m]);
            }
            for (int k = m-1; k >= j; k--) {
                res.add(matrix[n][k]);
            }
            for (int k = n-1; k >= i+1; k--) {
                res.add(matrix[k][j]);
            }
        }
    }
}
