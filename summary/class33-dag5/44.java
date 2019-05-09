class Solution {
    public boolean isMatch(String s, String p) {
        final int n = s.length();
        final int m = p.length();

        boolean[] pre = new boolean[n + 1];
        boolean[] cur = new boolean[n + 1];
        for (int j = m; j >= 0; j--) {
        	for (int i = n; i >= 0; i--) {
        		if (i == n && j == m) {
        			cur[i] = true;
        		} else if (j == m) {
        			cur[i] = false;
        		} else if (i == n) {
        			cur[i] = p.charAt(j) == '*' && pre[i];
        		} else {
        			if (p.charAt(j) == '*') {
        				boolean flag = false;
        				for (int k = i; k <= n; k++) {
        					if (pre[k]) {
        						flag = true;
        						break;
        					}
        				}
        				cur[i] = flag;
        			} else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
        				cur[i] = pre[i + 1];
        			} else {
        				cur[i] = false;
        			}
        		}
        		
        	}
        	boolean[] tmp = pre;
        	pre = cur;
        	cur = tmp;
    	}
    	return pre[0];
    }
}