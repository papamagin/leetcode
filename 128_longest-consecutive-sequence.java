//https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        Set<Integer> numsSet = new HashSet<>();
        for (int i : nums) {
            numsSet.add(i);
        }

        int res = 0;
        for (int i : numsSet) {
            if (!numsSet.contains(i-1)) {
                int current = i;
                int len = 1;
                while (numsSet.contains(current+1)) {
                    len++;
                    current++;
                }
                if (len > res) {
                    res = len;
                }
            }
        }

        return res;
    }
}
