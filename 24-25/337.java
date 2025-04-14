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
    public int rob(TreeNode root) {
        Node node = dfs(root);
        return Math.max(node.maxWithNode(), node.maxWithout());
    }

    private Node dfs(TreeNode root) {
        if (root == null) {
            return new Node(0, 0);
        }
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        int maxWithNode = root.val + left.maxWithout() + right.maxWithout();
        int maxWithout = Math.max(left.maxWithNode(), left.maxWithout()) + Math.max(right.maxWithNode(), right.maxWithout());
        return new Node(maxWithNode, maxWithout);
    }

    private record Node(int maxWithNode, int maxWithout) {

    }
}