//https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int res = -1;
        int count = 0;

        for (int i : nums) {
            if (count == 0) {
                res = i;
                count = 1;
            } else {
                count = i == res ? ++count : --count;
            }
        }

        return res;
    } 
}
