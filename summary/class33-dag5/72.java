class Solution {
    public int minDistance(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();

        int[] pre = new int[m];
        int[] cur = new int[m];
        for (int i = n - 1; i >= 0; i--) {
        	for (int j = m - 1; j >= 0; j--) {
        		if (i == n - 1 && j == m - 1) {
        			cur[j] = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
        		} else if (i == n - 1) {
        			cur[j] = 1 + cur[j + 1];
        		} else if (j == m - 1) {
        			cur[j] = 1 + pre[j];
        		} else {
        			if (word1.charAt(i) == word2.charAt(j)) {
        				cur[j] = pre[j + 1];
        			} else {
        				cur[j] = 1 + min(pre[j + 1], pre[j], cur[j + 1]);
        			}
        		}
        	}
        	int[] tmp = pre;
        	pre = cur;
        	cur = tmp;
        }
        return pre[0];
    }

    private int min(int... a) {
    	int min = Integer.MAX_VALUE;
    	for (int i : a) {
    		min = Math.min(min, i);
    	}
    	return min;
    }
}