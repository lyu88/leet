class Solution {
    public boolean checkEqualTree(TreeNode root) {
        int sum = sum(root);
        if (sum % 2 != 0) {
            return false;
        }
        int tgt = sum / 2;
        return dfs(root, tgt).found;
    }
    
    private int sum(TreeNode root) {
        return root == null ? 0 : root.val + sum(root.left) + sum(root.right);
    }

    private Result dfs(TreeNode root, int tgt) {
        // base case
        if (root == null) {
            return new Result(0, false);
        }
        // general case
        Result left = dfs(root.left, tgt);
        Result right = dfs(root.right, tgt);

        boolean found = left.found 
                        || right.found 
                        || (root.left != null && left.sum == tgt)
                        || (root.right != null &&right.sum == tgt);
        int sum = root.val + left.sum + right.sum;
        return new Result(sum, found);
    }

    private class Result {
        int sum;
        boolean found;
        public Result(int sum, boolean found) {
            this.sum = sum;
            this.found = found;
        }
    }

}