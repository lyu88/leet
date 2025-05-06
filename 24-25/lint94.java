/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        int[] ret = {Integer.MIN_VALUE};
        dfs(root, ret);
        return ret[0];
    }

    private int dfs(TreeNode root, int[] ret) {
        if (root == null) {
            return 0;
        }
        int max = root.val;
        int left = dfs(root.left, ret);
        if (left > 0) {
            max += left;
        }
        int right = dfs(root.right, ret);
        if (right > 0) {
            max += right;
        }
        ret[0] = Math.max(ret[0], max);
        return max(0, root.val, root.val + left, root.val + right);
    }

    int max(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        return max;
    }
}