//https://leetcode.com/problems/path-sum/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    private boolean dfs(TreeNode node, int currSum, int targetSum) {
        if (node == null) {
            return false;
        }
        currSum += node.val;
        if (node.left == null && node.right == null) {
            return currSum == targetSum;
        }
        return dfs(node.left, currSum, targetSum) || dfs(node.right, currSum, targetSum);
    }
}
