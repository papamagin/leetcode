//https://leetcode.com/problems/valid-perfect-square/description/

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int l = 1;
        int r = num/2;
        while (l <= r) {
            int mid = l + (r - l)/2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            }
            if (square < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
