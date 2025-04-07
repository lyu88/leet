class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return dfs(root, p, q);
        }
        return dfs(root, q, p);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q 
            || p.val < root.val && root.val < q.val) {
            return root;
        }
        if (root.val < p.val) {
            return dfs(root.right, p, q);
        }
        return dfs(root.left, p, q);
    }
}