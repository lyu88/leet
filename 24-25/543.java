class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ret = {0};
        dfs(root, ret);
        return ret[0] - 1;
    }

    private int dfs(TreeNode root, int[] ret) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, ret);
        int right = dfs(root.right, ret);
        int maxWithNode = 1 + Math.max(left, right);
        ret[0] = Math.max(ret[0], 1 + left + right);
        return maxWithNode;
    }
}