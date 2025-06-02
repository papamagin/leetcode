//https://leetcode.com/problems/maximum-subarray/description/

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i : nums) {
            currSum += i;
            res = Math.max(res, currSum);
            currSum = currSum < 0 ? 0 : currSum;
        }
        return res;
    }
}
