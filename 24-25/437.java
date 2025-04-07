class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int[] ret = new int[1];
        Map<Long, Integer> preSums = new HashMap<>();
        preSums.put(0L, 1);
        dfs(root, targetSum, 0L, preSums, ret);
        return ret[0];
    }

    private void dfs(TreeNode root, final long target, long path, Map<Long, Integer> preSums, int[] ret) {
        path += root.val; 
        if (preSums.containsKey(path - target)) {
            ret[0] += preSums.get(path - target);
        }
        preSums.put(path, preSums.getOrDefault(path, 0) + 1);
        if (root.left != null) {
            dfs(root.left, target, path, preSums, ret);
        }
        if (root.right != null) {
            dfs(root.right, target, path, preSums, ret);
        }
        preSums.put(path, preSums.get(path) - 1);
    }
}