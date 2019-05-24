class Solution {
    public int numDistinct(String s, String t) {
    	int[] pre = new int[t.length() + 1];
    	int[] cur = new int[t.length() + 1];
    	for (int row = s.length(); row >= 0; --row) {
    		for (int col = t.length(); col >= 0; --col) {
    			if (col == t.length()) {
    				cur[col] = 1;
    			} else if (row == s.length()) {
    				cur[col] = 0;
    			} else {
    				cur[col] = pre[col];
    				if (s.charAt(row) == t.charAt(col)) {
    					cur[col] += pre[col + 1];
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