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
    public int distributeCoins(TreeNode root) {
        int[] ret = new int[1];
        dfs(root, ret);
        return ret[0];
    }

    private int dfs(TreeNode root, int[] ret) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, ret);
        int right = dfs(root.right, ret);
        ret[0] += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}