// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

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
// class Solution {
//     private Queue<Integer> q = new PriorityQueue<>();
//     public int kthSmallest(TreeNode root, int k) {
//         dfs(root);
//         for (int i = 0; i < k - 1; i++) {
//             q.poll();
//         }
//         return q.peek();
//     }
//     private void dfs(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         q.offer(root.val);
//         dfs(root.left);
//         dfs(root.right);
//     }
// }

class Solution {
    int counter;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        counter--;
        if (counter == 0) {
            res = root.val;
        }
        if (counter > 0) {
            dfs(root.right);
        }
    }
}
