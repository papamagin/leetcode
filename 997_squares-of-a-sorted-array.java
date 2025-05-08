//https://leetcode.com/problems/squares-of-a-sorted-array/description/

class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] reversed = new int[nums.length];
        int count = 0;
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int lSquare = nums[l]*nums[l];
            int rSquare = nums[r]*nums[r];
            if (lSquare >= rSquare) {
                reversed[count] = nums[l]*nums[l];
                l++;
            } else {
                reversed[count] = nums[r]*nums[r];
                r--;
            }
            count++;
        }

        for (int i = 0; i < reversed.length/2; i++) {
            int temp = reversed[i];
            reversed[i] = reversed[reversed.length - i - 1];
            reversed[reversed.length - i - 1] = temp;
        }

        return reversed;
    }
}
