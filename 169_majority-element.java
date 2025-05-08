//https://leetcode.com/problems/majority-element/description/

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            int currentCount = m.getOrDefault(i, 0);
            m.put(i, currentCount+1);
        }
        int[] res = new int[]{0};
        int[] maxCount = new int[]{0};
        m.entrySet().forEach( entry -> {
            if (entry.getValue() > maxCount[0]) {
                maxCount[0] = entry.getValue();
                res[0] = entry.getKey();
            }
        });

        return res[0];
    } 
}
