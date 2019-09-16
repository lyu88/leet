/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        int sumIfPicked = leftRes[1] + rightRes[1] + root.val;
        int sumIfNotPicked = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        return new int[]{sumIfPicked, sumIfNotPicked};
    }
    
   
}