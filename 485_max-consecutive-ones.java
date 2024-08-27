// https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curLen = 0;
        boolean isSeq = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                isSeq = true;
                curLen++;
                if (i == nums.length-1) {
                    // end of nums
                    if (curLen > max) {
                        max = curLen;
                    }
                }

                continue;
            }

            // nums[i] == 0
            if (!isSeq) {
                continue;
            }

            // end of current sequence
            if (curLen > max) {
                max = curLen;
            }
            curLen = 0;
            isSeq = false;
        }

        return max;
    }
}
