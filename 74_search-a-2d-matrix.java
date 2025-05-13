//https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = n * m - 1;

        while (l <= r) {
            int mid = l + (r - l)/2;
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
