

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return results;
        }
        dfs(root, sum, results, path);
        return results;
    }
    
    // final version: faster and could save space - noted there is no return
    private void dfs(TreeNode root, int sum, List<List<Integer>> results, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                results.add(new ArrayList<>(path));
            }
            // return ; there is no return here
        }
       
        
        if (root.left != null) 
            dfs(root.left, sum - root.val, results, path);
        if (root.right != null) 
            dfs(root.right, sum - root.val, results, path);
        path.remove(path.size() - 1);
    }

    // intuitive, with a return there is fine as no need to remove it from the path
    private void dfs1(TreeNode root, int sum, List<List<Integer>> results, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                results.add(path);
            }
            return ;
        }
       
        
        if (root.left != null) 
            dfs(root.left, sum - root.val, results, new ArrayList<>(path));
        if (root.right != null) 
            dfs(root.right, sum - root.val, results, new ArrayList<>(path));
    }
}