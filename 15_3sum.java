//https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // the sum of 3 positive numbers is greater than 0
            if (nums[i] > 0) {
                break;
            }
            // skip duplicates
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;
            while (l<r) {
                if (nums[i]+nums[l]+nums[r] == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // skip duplicates again
                    while (l<r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    // skip duplicates again
                    while (l<r && nums[r] == nums[r+1]) {
                        r--;
                    }
                } else if (nums[i]+nums[l]+nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;
    }
}
