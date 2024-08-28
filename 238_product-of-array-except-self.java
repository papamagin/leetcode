https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProd = new int[nums.length];
        int[] suffixProd = new int[nums.length];

        prefixProd[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixProd[i] = prefixProd[i-1] * nums[i];
        }

        suffixProd[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i > -1; i--) {
            suffixProd[i] = suffixProd[i+1] * nums[i];
        }

        int[] res = new int[nums.length];
        res[0] = suffixProd[1];
        res[nums.length-1] = prefixProd[nums.length-2];
        for (int i = 1; i < nums.length-1; i++) {
            res[i] = prefixProd[i-1]*suffixProd[i+1];
        }

        return res;
    }
}
