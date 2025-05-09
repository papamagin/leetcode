//https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int res = 0;

        while (l < r) {
            int area = (r - l)*Math.min(height[l],height[r]);
            if (area > res) {
                res = area;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        
        return res;
    }
}
