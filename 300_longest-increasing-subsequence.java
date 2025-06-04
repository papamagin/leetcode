//https://leetcode.com/problems/longest-increasing-subsequence/description/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int res = 1;
        int[] dp = new int[n]; // dp[i] = LIS ending with nums[i]
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
