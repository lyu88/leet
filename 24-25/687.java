class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] ret = {0};
        dfs( root, ret);
        return ret[0] == 0 ? 0 : ret[0] - 1;
    }

    private int dfs(TreeNode root, int[] ret) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        int maxWithNode = 1;
        int left = dfs(root.left, ret);
        if (root.left != null && root.val == root.left.val) {
            ans += left;
            maxWithNode += left;
        }
        int right = dfs(root.right, ret);
        if (root.right != null && root.val == root.right.val) {
            ans += right;
            maxWithNode = Math.max(maxWithNode, 1 + right);
        }
        ret[0] = Math.max(ret[0], ans);
        return maxWithNode;
    }
}