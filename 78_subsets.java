//https://leetcode.com/problems/subsets/description/

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }
    private void dfs(int i, int[] nums) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        dfs(i + 1, nums);
        curr.remove(curr.size() - 1);
        dfs(i + 1, nums);
    }
}
