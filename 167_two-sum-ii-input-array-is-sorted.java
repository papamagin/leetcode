//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (l < r) {
            int res = numbers[l] + numbers[r];
            if (res == target) {
                return new int[]{l+1, r+1};
            } else if (res < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[2];
    }
}
