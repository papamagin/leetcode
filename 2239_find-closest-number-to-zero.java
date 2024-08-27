// https://leetcode.com/problems/find-closest-number-to-zero/description/
class Solution {
    public int findClosestNumber(int[] nums) {
        // O(n)
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int delta = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int curr_delta = Math.abs(0 - nums[i]);

            if (curr_delta < delta) {
                delta = curr_delta;
                res = nums[i];
            }

            if (curr_delta == delta && nums[i] > res) {
                res = nums[i];
            }

        }

        return res;
    }
}
