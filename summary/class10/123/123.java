class Solution {
    public int maxProfit(int[] a) {
        if (a.length == 0) {
        	return 0;
        }
        final int n = a.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int min = Integer.MAX_VALUE;
       	int maxProf = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
        	min = Math.min(a[i], min);
        	maxProf = Math.max(a[i] - min, maxProf);
        	leftMax[i] = maxProf;
        }
        int max = Integer.MAX_VALUE;
       	maxProf = Integer.MIN_VALUE;
       	int result = Integer.MIN_VALUE;
       	for (int i = n - 1; i >= 0; i--) {
       		max = Math.max(a[i], max);
       		maxProf = Math.max(max - a[i], maxProf);
       		rightMax[i] = maxProf;
       		result = Math.max(leftMax[i] + rightMax[i], result);
       	}
       	return result;
    }


    public int maxProfit121(int[] prices) {
        if (prices.length == 0) {
        	return 0;
        }
        int min = Integer.MAX_VALUE;
       	int maxProf = Integer.MIN_VALUE;
        final int n = prices.length;
        for (int i = 0; i < n; i++) {
        	min = Math.min(prices[i], min);
        	maxProf = Math.max(prices[i] - min, maxProf);
        }
        return maxProf;
    }
}
