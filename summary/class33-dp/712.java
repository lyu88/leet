class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        final int n = s1.length();
        final int m = s2.length();
        int[] pre = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int i = n; i >= 0; i--) {
        	for (int j = m; j >= 0; j--) {
        		if (i == n && j == m) {
        			cur[j] = 0;
        		} else if (i == n) {
        			cur[j] = s2.charAt(j) + cur[j + 1]; 
        		} else if (j == m) {
        			cur[j] = pre[j] + s1.charAt(i); 
        		} else {
        			if (s1.charAt(i) != s2.charAt(j)) {
        				cur[j] = Math.min(s2.char(j) + cur[j + 1], s1.char(i) + spre[j]);
        			} else {
        				cur[j] = pre[j + 1];
        			}
        		}
        	}
        	int[] tmp = pre;
        	pre = cur;
        	cur = tmp;
        }
        return pre[0];
    }
}