class Solution {
	public int minFallingPathSum(int[][] A) {
		final int n = A[0].length;
    	if (n == 1) {
    		return A[0][0];
    	}
    	int[] pre = A[0].clone();
    	int[] allResults = new int[n];
    	for (int i = 1; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (j == 0) {
    				allResults[j] = A[i][j] + findMin(pre[0], pre[1]);
    			} else if (j == n - 1) {
    				allResults[j] = A[i][j] + findMin(pre[n - 2], pre[n - 1]);
    			} else {
    				allResults[j] = A[i][j] + findMin(pre[j - 1], pre[j], pre[j + 1]);
    			}
    		}
    		pre = allResults;
    	}
    	return findMin(allResults);
	}

	private int findMin(int... a) {
		int min = Integer.MAX_VALUE;
		for (int i : a) {
			min = Math.min(min, i);
		}
		return min;
	}



	/* 1 2 3
	   4 5 6
	   7 8 9
	** 题意理解错了（这里col diff 应是at most 1, NOT at least 1）
	** 即使理解成col diff at least 1, 思路也错了。应考虑相等的情况(跑上面例子)，可能还是需要一个一维数组存all results
    public int minFallingPathSum(int[][] A) {
    	final int n = A[0].length;
    	if (n == 1) {
    		return A[0][0];
    	}
    	IndexNode preIndexNode = new IndexNode(-1, -1);
    	find(A[0], n, preIndexNode);
    	int minSum1 = A[0][preIndexNode._min1];
    	int minSum2 = A[0][preIndexNode._min2];
    	IndexNode curIndexNode = new IndexNode(-1, -1);
    	for (int i = 1; i < n; i++) {
    		find(A[i], n, curIndexNode);
    		if (curIndexNode._min1 != preIndexNode._min1) {
    			minSum1 += A[i][curIndexNode._min1];
    			if (curIndexNode._min2 != preIndexNode._min1) {
    				minSum2 = minSum1 + A[i][curIndexNode._min2];
    			} else {
    				minSum2 += A[i][curIndexNode._min2];
    			}
    			
    		} else {
    			if (minSum1 + A[i][curIndexNode._min2] < minSum2 + A[i][curIndexNode._min1]) {
    				minSum1 += A[i][curIndexNode._min2];
    				minSum2 += A[i][curIndexNode._min1];
    				int temp = curIndexNode._min1;
    				curIndexNode._min1 = curIndexNode._min2;
    				curIndexNode._min2 = temp;
    			} else {
    				minSum1 = minSum2 + A[i][curIndexNode._min1];
    				minSum2 = minSum1 + A[i][curIndexNode._min2];
    			}
    		}
    		preIndexNode = curIndexNode;
    	}
        return minSum1;
    }

    private void find(int[] a, int n, IndexNode node) {
    	int first = 0;
    	int second = 1;
    	for (int i = 1; i < n; i++) {
    		if (a[i] < a[first]) {
    			second = first;
    			first = i;
    		} else if (a[i] < a[second]) {
    			second = i;
    		}
    	}
    	node._min1 = first;
    	node._min2 = second;
    }

    private class IndexNode {
    	int _min1;
    	int _min2;

    	public IndexNode(int min1, int min2) {
    		_min1 = min1;
    		_min2 = min2;
    	}
    }
}