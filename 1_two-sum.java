https://leetcode.com/problems/two-sum/description/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numsMap.keySet().contains(diff)) {
                int candidate = numsMap.get(diff);
                if (candidate != i) {
                    return new int[]{i, candidate};
                }
            }
        }

        return new int[2];
    }
}
