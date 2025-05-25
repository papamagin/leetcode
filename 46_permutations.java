//https://leetcode.com/problems/permutations/submissions/1643878398/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), used, res);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            curr.add(nums[i]);
            used[i] = true;
            backtrack(nums, curr, used, res);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
