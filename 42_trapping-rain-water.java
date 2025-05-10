//https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int[] maxLeft = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            maxLeft[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        int[] maxRight = new int[n];
        for (int i = n-1; i >= 0 ; i--) {
            maxRight[i] = max;
            max = Math.max(max, height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int h = Math.min(maxLeft[i], maxRight[i]);
            if (h > height[i]) {
                res += h - height[i];
            }
        }
        return res;
    }
}
