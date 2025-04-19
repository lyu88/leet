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
// preorder traversal the whole tree
// seems nothing to do with bst
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o2, o1));
        dfs(root, k, maxHeap);
        return maxHeap.peek();
    }

    private void dfs(TreeNode root, final int k, PriorityQueue<Integer> maxHeap) {
        if (root == null) {
            return;
        }
        if (maxHeap.size() < k) {
            maxHeap.add(root.val);
        } else {
            if (root.val < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(root.val);
            }
        }
        dfs(root.left, k, maxHeap);
        dfs(root.right, k, maxHeap);
    }
}

// oh you forgot 1 important feature
// bst inorder traversal is sorted

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        inorder(root, k, new int[1], res);
        return res[0];
    }

    private void inorder(TreeNode root, final int k, int[] count, int[] res) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, count, res);
        count[0]++;
        if (count[0] == k) {
            res[0] = root.val;
            return;
        }
        inorder(root.right, k, count, res);
    }
}