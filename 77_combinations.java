//https://leetcode.com/problems/combinations/description/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }
    private void backtrack(int i, int n, int k, List<Integer> curr) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        int numbersLeft = n - i + 1;
        int numbersNeed = k - curr.size();
        if (numbersLeft > numbersNeed) {
            backtrack(i + 1, n, k, curr);
        }
        curr.add(i);
        backtrack(i + 1, n, k, curr);
        curr.remove(curr.size() - 1);
    }
}
