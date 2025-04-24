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
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */


    TreeNode first = null;
    TreeNode last = null;

  public void dfs(TreeNode node) {
    if (node != null) {
      // left
      dfs(node.left);
      // node 
      if (last != null) {
        // link the previous node (last)
        // with the current one (node)
        last.right = node;
        node.left = last;
      }
      else {
        // keep the smallest node
        // to close DLL later on
        first = node;
      }
      last = node;
      // right
      dfs(node.right);
    }
  }
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        dfs(root);
        first.left = last;
        last.right = first;
        return first;
    }
}