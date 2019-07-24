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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
        	return root;
        }
        if (root.val < val) {
        	return searchBST(root.right, val);
        } else {
			return searchBST(root.left, val);
        }
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
        	return lowestCommonAncestor(root, q, p);
        }
        if (p.val <= root.val && root.val <= q.val) {
        	return root;
        }
        if (root.val < p.val) {
        	return lowestCommonAncestor(root.right, p, q);
        } 
        return lowestCommonAncestor(root.left, p, q);
    }
}