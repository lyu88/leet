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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    
    private String dfs(TreeNode root, String suffix) {
        
        if (root == null) {
            return suffix;
        }
        suffix = (char)(97 + root.val) + suffix;
        String left = dfs(root.left, suffix);
        String right = dfs(root.right, suffix);
        if (root.left == null) {
        	return right;
        } 
        if (root.right == null) {
        	return left;
        }
        return left.compareTo(right) <= 0 ? left : right;
    }
}