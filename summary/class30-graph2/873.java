class Solution {
    public int lenLongestFibSubseq(int[] A) {
    	final int n = A.length;
    	int[][] allResults = new int[n][n];
    	int max = 0;
    	for (int i = 2; i < n; i++) {
    		int left = 0, right = i - 1;
    		while (left < right) {
	    		if (A[left] + A[right] == A[i]) {
	    			allResults[right][i] = allResults[left][right] == 0 ? 3 : allResults[left][right] + 1;
	    			max = Math.max(max, allResults[right][i]);
	    			left++;
	    			right--;
	    		} else if (A[left] + A[right] < A[i]) {
	    			left++;
	    		} else {
	    			right--;
	    		}
	    	}
    	}
    	
    	return max;
    }
}