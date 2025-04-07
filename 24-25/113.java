class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allRes = new ArrayList<>();
        if (root == null) {
            return allRes;
        }
        dfs(root, targetSum, new ArrayList<>(), allRes);
        return allRes;
    }

    private void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> allRes) {
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                allRes.add(new ArrayList<>(path));
            }
        }
        if (root.left != null) {
            dfs(root.left, target, path, allRes);
        }
        if (root.right != null) {
            dfs(root.right, target, path, allRes);
        }
        path.removeLast();
    }
}