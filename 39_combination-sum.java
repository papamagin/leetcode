//https://leetcode.com/problems/combination-sum/description/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 1 && candidates[0] > target) {
            return List.of();
        }
        backtrack(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }
    private void backtrack(int pos, int sum, List<Integer> curr, int[] candidates, int target) {
        if (sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            curr.add(candidates[i]);
            backtrack(i, sum + candidates[i], curr, candidates, target);
            curr.remove(curr.size() - 1);
        }
    }
}
