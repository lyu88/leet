class Solution {
    public int getMinimumDifference(TreeNode root) {
        int[] ret = {Integer.MAX_VALUE};
        TreeNode[] prev = new TreeNode[1];
        inorder(root, prev, ret);
        return ret[0];
    }

    private void inorder(TreeNode root, TreeNode[] prev, int[] minDiff) {
        if (root == null) {
            return;
        }
        inorder(root.left, prev, minDiff);
        if (prev[0] != null) {
            minDiff[0] = Math.min(minDiff[0], Math.abs(root.val - prev[0].val));
        }
        prev[0] = root;
        inorder(root.right, prev, minDiff);
    }
}