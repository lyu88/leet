import java.util.ArrayList;
import java.util.List;

/**
 *
 *     1
 *    2  3
 *   2 5 4 7
 *
 */

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        /*List<TreeNode> forest = new ArrayList<>();
        dfs(root, 2, forest, null);
        List<TreeNode> forest2 = new ArrayList<>();
        for (TreeNode node : forest) {
            dfs(node, 3, forest2, null);
        }*/
        System.out.println(delete(root, List.of(2, 3)));
    }

    static List<Integer> delete(TreeNode root, List<Integer> vals) {
        List<TreeNode> forest = List.of(root);
        for (int val : vals) {
            List<TreeNode> newForest = new ArrayList<>();
            for (TreeNode treeNode : forest) {
                dfs(treeNode, val, newForest, null);
            }
            forest = newForest;
        }
        return forest.stream().map(t -> t.val).toList();
    }

    static TreeNode dfs( TreeNode root, int val, List<TreeNode> forest, TreeNode pre) {
        if (root == null) {
            return null;
        }
        // Recursively process children
        root.left = dfs(root.left, val, forest, root);
        root.right = dfs(root.right, val, forest, root);

        // If current node should be removed
        if (root.val == val) {
            if (root.left != null) forest.add(root.left);
            if (root.right != null) forest.add(root.right);
            return null; // Remove current node
        }

        // If it's a root node (i.e. not a child of a removed node), and not removed itself
        if (pre == null) forest.add(root);
        return root;
    }

    static TreeNode dfs( TreeNode root, int val, List<TreeNode> forest, boolean isRoot) {
        if (root == null) {
            return null;
        }
        // Recursively process children
        root.left = dfs(root.left, val, forest, false);
        root.right = dfs(root.right, val, forest, false);

        // If current node should be removed
        if (root.val == val) {
            if (root.left != null) forest.add(root.left);
            if (root.right != null) forest.add(root.right);
            return null; // Remove current node
        }

        // If it's a root node (i.e. not a child of a removed node), and not removed itself
        if (isRoot) forest.add(root);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}