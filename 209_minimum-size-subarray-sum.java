//https://leetcode.com/problems/minimum-size-subarray-sum/description/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 1 && nums[0] < target) {
            return 0;
        }
        int res = n;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while ( l <= r && sum >= target && sum - nums[l] >= target ) {
                sum -= nums[l];
                l++;
            }
            if (sum >= target) {
                res = Math.min(res, r - l + 1);
            }
        }

        return l == 0 && sum < target ? 0 : res;
    }
}
