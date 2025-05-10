/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root
     * @return: the maximum width of the given tree
     */
    class Node {
        TreeNode root;
        int index;
        public Node(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        int max = 1;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            final int size = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == 0) {
                    start = node.index;
                }
                if (i == size - 1) {
                    end = node.index;
                    max = Math.max(max, end - start + 1);
                }
                if (node.root.left != null) {
                    queue.add(new Node(node.root.left, node.index *2));
                }
                if (node.root.right != null) {
                    queue.add(new Node(node.root.right, node.index *2 + 1));
                }
            }
        }
        return max;
    }
}