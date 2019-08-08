class Solution {
    public int distributeCoins(TreeNode root) {
        
    }

    private Result dfs(TreeNode root) {
    	if (root == null) {
    		return new Result(0, 0);
    	}

    	Result leftRes = dfs(root.left);
    	Result rightRes = dfs(root.right);

    	int bal = root.val + leftRes._balance + rightRes._balance - 1;
    	int sum = Math.max(bal) + Math.max(leftRes._balance) + Math.max(rightRes._balance);
    }
    
    private class Result {
        int _sum;
        int _balance;
        public Result(int sum, int balance) {
        	_sum = sum;
        	_balance = balance;
        }
    }
}