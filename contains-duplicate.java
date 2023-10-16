// https://leetcode.com/problems/contains-duplicate/description/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        // Arrays.sort(nums);

        // for(int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] == nums[i + 1]) {
        //         return true;
        //     }
        // }

        // return false;

        Set<Integer> hset = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if (hset.contains(nums[i])) {
                return true;
            }
            hset.add(nums[i]);
        }

        return false;
    }
}
