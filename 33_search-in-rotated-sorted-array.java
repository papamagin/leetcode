//https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //find the minimum to divide nums into two asc arrays
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r)/2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int leftSearch = binarySearch(0, l - 1, nums, target);
        if (leftSearch > -1) {
            return leftSearch;
        }
        return binarySearch(l, nums.length - 1, nums, target);
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        if (r < 0) {
            return -1;
        }
        while (l <= r) {
            int mid = (l + r)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
