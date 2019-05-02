class Solution {

    public int smallestFactorization(int a) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(new TreeNode(a, a, null));
        TreeNode found = null;
        while (!queue.isEmpty()) {
        	TreeNode node = queue.remove();
        	if (node.val < 10) {
        		found = node;
        		break;
        	}
        	for (int i = 2; i < 10; i++) {
        		if (node.val % i == 0) {
        			TreeNode child = new TreeNode(val / i, i, node);
        			node.children.add(child);
        			queue.add(child);
        		}	
        	}
        }
        if (found != null) {
        	int sum = 0;
        	int count = 1;
        	while (node != null) {
        		if (sum + count * node.digit < sum) {
        			return 0;
        		}
        		sum += count * node.digit;
        		count *= 10;
        		node = node.parent;
        	}
        	return sum;
        } else {
        	return 0;
        }
    }

    private class TreeNode {
    	int val;
    	int digit;
    	ArrayList<TreeNode> children = new ArrayList<>();
    	TreeNode parent;
    	TreeNode(int val, int digit, TreeNode parent) {
    		this.val = val;
    		this.digit = digit;
    		this.parent = parent;
    	}
    }
}