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
     * @param t: the root of tree
     * @return: return a string
     */
    public String tree2str(TreeNode t) {
        String res = dfs(t);
        return res.substring(1, res.length() - 1);
    }

    private String dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return "(" + node.val + ")";
        }
        if (node.left == null) {
            return "(" + node.val + "()" + dfs(node.right) + ")";
        }
        if (node.right == null) {
            return "(" + node.val + dfs(node.left) + ")";
        }
        return "(" + node.val + dfs(node.left) + dfs(node.right) + ")";
    }
 }