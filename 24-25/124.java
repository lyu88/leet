class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ret = {Integer.MIN_VALUE};
        dfs(root, ret);
        return ret[0];
    }

    private Node dfs(TreeNode root, int[] ret) {
        if (root == null) {
            return new Node(0, Integer.MIN_VALUE);
        }
        Node left = dfs(root.left, ret);
        Node right = dfs(root.right, ret);
        int maxWithNode = root.val + Math.max(left.maxWithNode(), right.maxWithNode());
        if (maxWithNode < root.val) {
            maxWithNode = root.val;
        }
        int max = Math.max(left.max(), right.max());
        max = Math.max(max, maxWithNode);
        max = Math.max(max, root.val + left.maxWithNode() + right.maxWithNode());
        ret[0] = Math.max(ret[0], max);
        return new Node(maxWithNode, max);
    }

    private record Node(int maxWithNode, int max) {

    }
}

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
    public int maxPathSum(TreeNode root) {
        int[] ret = {Integer.MIN_VALUE};
        dfs(root, ret);
        return ret[0];
    }

    private int dfs(TreeNode root, int[] ret) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, ret);
        int right = dfs(root.right, ret);
        int maxWithNode = root.val + Math.max(left, right);
        if (maxWithNode < root.val) {
            maxWithNode = root.val;
        }
        int max = Math.max(maxWithNode, root.val + left + right);
        ret[0] = Math.max(ret[0], max);
        return maxWithNode;
    }
}