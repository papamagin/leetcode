//https://leetcode.com/problems/jump-game/description/

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int prevPos = -1;
        int pos = 0;
        while (prevPos < pos) {
            if (nums[pos] + pos >= n - 1) {
                return true;
            }
            int newPos = pos;
            int maxPossibleNextJump = nums[pos] + pos;
            for (int i = 0; i <= nums[pos]; i++) {
                if (nums[pos + i] + pos + i >= maxPossibleNextJump) {
                    newPos = pos + i;
                    maxPossibleNextJump = nums[pos + i] + pos + i;
                }
            }
            prevPos = pos;
            pos = newPos;
        }
        return false;
    }
}
