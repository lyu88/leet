/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(arr));
        return buildTree(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(Queue<String> queue, int low, int high) {
        if (queue.isEmpty()) return null;
        String s = queue.peek();
        int val = Integer.valueOf(s);
        if (val < low || val > high) {
            return null;
        }
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = buildTree(queue, low, val);
        root.right = buildTree(queue, val, high);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;