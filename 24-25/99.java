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
    public void recoverTree(TreeNode root) {
        TreeNode[] first = new TreeNode[1];
        TreeNode[] second = new TreeNode[1];
        TreeNode[] prev = new TreeNode[1];
        inorder(root, first, second, prev);
        int tmp = first[0].val;
        first[0].val = second[0].val;
        second[0].val = tmp;
    }

    private void inorder(TreeNode root, TreeNode[] first, TreeNode[] second,TreeNode[] prev) {
        if (root == null) {
            return;
        }
        inorder(root.left, first, second, prev);
        if (prev[0] != null) {
            if (first[0] == null && prev[0].val > root.val) {
                first[0] = prev[0];
            }
            if (first[0] != null && prev[0].val > root.val) {
                second[0] = root;
            }
        }
        prev[0] = root;
        inorder(root.right, first, second, prev);
    }
}