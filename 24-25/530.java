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


// similar
// bst inorder is sorted
private void inorder(TreeNode root, TreeNode[] pre, int[] ret) {
        if (root.left != null) {
            inorder(root.left, pre, ret);
        }
        if (pre[0] != null) {
            ret[0] = Math.min(ret[0], Math.abs(pre[0].val - root.val));
        }
        pre[0] = root;
        if (root.right != null) {
            inorder(root.right, pre, ret);
        }
    }