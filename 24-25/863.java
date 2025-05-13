/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Stack<TreeNode> path = new ArrayList<>();
        dfs(root, target, path);
        final int max = path.size();
        TreeNode pre = null;
        List<Integer> allRes = new ArrayList<>();
        for (int i = 0; i <= Math.min(max - 1, k); i++) {
            TreeNode cur = path.pop();
            if (pre == null) {
                allRes.addAll(bfs(cur, k));
            } else if (cur.left == pre) {
                cur.left = null;
                allRes.addAll(bfs(cur, k-i));
            } else {
                cur.right = null;
                allRes.addAll(bfs(cur, k-i));
            }
            pre = cur;
        }
        return allRes;
    }

    private List<Integer> bfs(TreeNode root, int depth) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        List<Integer> res = new ArrayList<>();
        int k = 0;
        while (!que.isEmpty()) {
            final int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (k == depth) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            if (k == depth) {
                break;
            }
            k++;
        }
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode target, Stack<TreeNode> path) {
        path.push(root);
        if (root == target) {
            return true;
        }
        if (root.left != null && dfs(root.left, target, path)) {
            return true;
        }
        if (root.right != null && dfs(root.right, target, path)) {
            return true;
        }
        path.pop();
        return false;
    }
    
}