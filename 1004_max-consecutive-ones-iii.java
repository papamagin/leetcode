//https://leetcode.com/problems/max-consecutive-ones-iii/description/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int zeros = 1 - nums[0];
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            while (l <= r && zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
            if (r < nums.length && nums[r] == 0) {
                zeros++;
            }
        }
        return res;
    }
}
