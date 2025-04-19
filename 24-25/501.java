/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        int[] ret = new int[1];
        inorder(root, new TreeNode[1], new int[1], ret);
        int max = ret[0];
        List<Integer> modes = new ArrayList<>();
        trav(root, new TreeNode[1], new int[1], max, modes);
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void trav(TreeNode root, TreeNode[] pre, int[] count, final int max,
        List<Integer> modes) {
        if (root == null) {
            return;
        }
        trav(root.left, pre, count, max, modes);
        if (pre[0] != null && pre[0].val == root.val) {
            count[0]++;
        } else {
            count[0] = 1;
        }
        if (max == count[0]) {
            modes.add(root.val);
        }
        pre[0] = root;
        trav(root.right, pre, count, max, modes);
    }

    private void inorder(TreeNode root, TreeNode[] pre, int[] count, int[] ret) {
        if (root == null) {
            return;
        }
        inorder(root.left, pre, count, ret);
        if (pre[0] != null && pre[0].val == root.val) {
            count[0]++;
        } else {
            count[0] = 1;
        }
        ret[0] = Math.max(ret[0], count[0]);
        pre[0] = root;
        inorder(root.right, pre, count, ret);
    }
}