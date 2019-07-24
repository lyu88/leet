class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        return dfs(root)._size;
    }

    private Result dfs(TreeNode root) {
    	// base case
    	if (root == null) {
    		return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    	}
    	// general case
    	Result left = dfs(root.left);
    	Result right = dfs(root.right);
    	boolean isBST = left._isBST && right._isBST 
    					&& (left._max < root.val)
    					&& (root.val < right._min);
    	int min = root.left == null ? root.val : left._min;
    	int max = root.right == null ? root.val : right._max;
    	int size = isBST ? left._size + right._size + 1 : Math.max(left._size, right._size);
    	return new Result(isBST, min, max, size);
    }


    private class Result {
    	boolean _isBST;
    	int _min;
    	int _max;
    	int _size;
    	public Result(boolean isBST, int min, int max, int size) {
    		_isBST = isBST;
    		_min = min;
    		_max = max;
    		_size = size;
    	}
    }
}