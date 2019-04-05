class Solution {
    public int closestValue(TreeNode root, double tgt) {
        TreeNode result = root;
        while (root != null) {
        	result = min(root, result, tgt);
        	if (root.val < tgt) {
        		root = root.right;
        	} else {
        		root = root.left;
        	}
        }
        return result.val;
    }

    private TreeNode min(TreeNode root, TreeNode result, double tgt) {
		return Math.abs(root.val - tgt) < Math.abs(result.val - tgt) ? root : result;
    }
}