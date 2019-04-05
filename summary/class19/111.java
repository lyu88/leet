class Solution {
    public int minDepth(TreeNode root) {
        /**
         *  将 2叉树 转为 16叉树:
         *      原 2叉树的左孩子，随机分配到16叉树 0-->7 某一个孩子上
         *      原 2叉树的右孩子，随机分配到16叉树 8-->15 某一个孩子上
         */
        MyTreeNode myRoot = copy(root, new Random());
        
        /**
         *  求原问题作用在16叉树上的答案
         */

        // special case
        if (myRoot == null) {
            return 0;
        }
        return minDepth(myRoot);
    }
    
    private int minDepth(MyTreeNode myRoot) {
        // base case
        if (isLeafNode(myRoot)) {
            return 1;
        }
        // general case
        int[] results = new int[16];
        for (int i = 0; i < 16; i++) {
            MyTreeNode child = myRoot.children[i];
            results[i] = child == null ? Integer.MAX_VALUE : minDepth(child);
        }
        return min(results) + 1;
    }

    private int min(int... arr) {
        int result = Integer.MAX_VALUE;
        for (int val : arr) {
            result = Math.min(result, arr);
        }
        return result;
    }

    private boolean isLeafNode(MyTreeNode myRoot) {
        for (MyTreeNode child : myRoot.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
    
    private MyTreeNode copy(TreeNode root, Random random) {
        if (root == null) {
            return null;
        }
        
        MyTreeNode myRoot = new MyTreeNode(root.val);
        myRoot.children[random.nextInt(8)] = copy(root.left, random);
        myRoot.children[random.nextInt(8) + 8] = copy(root.right, random);
        return myRoot;
    }
    
    private class MyTreeNode {
        int val;
        MyTreeNode[] children = new MyTreeNode[16];
        MyTreeNode(int x) {
            val = x;
        }
    }
}