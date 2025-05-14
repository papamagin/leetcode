//https://leetcode.com/problems/maximum-average-subarray-i/description/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }

        return (double) maxSum / k;
    }
}
