class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> results = new ArrayList<>();
        for (String query : queries) {
        	results.add(camelMatch(query, pattern));
        }
        return results;
    }

    private boolean camelMatch(String q, String p) {
    	final int n = q.length();
    	final int m = p.length();
    	int i = 0, j = 0;
    	while (i < n && j < m) {
    		char a = q.charAt(i);
    		char b = p.charAt(j);
    		if (a == b) {
    			i++;
    			j++;
    		} else {
    			if (!Character.isUpperCase(a)) {
    				i++;
    			} else {
    				return false;
    			}
    		}
    	}
    	while (i < n) {
    		char a = q.charAt(i);
    		if (!Character.isUpperCase(a)) {
				i++;
			} else {
				return false;
			}
    	}
    	return j == m;
    }
}


//dp
class Solution {
    public List<Boolean> camelMatch(String[] queries, String t) {
        List<Boolean> ret = new ArrayList<>();
        
        for (String s : queries) {
            boolean res = isMatch(s, t);
            ret.add(res);
        }
        
        return ret;
    }
    
    private boolean isMatch(String s, String t) {
        final int m = s.length();
        final int n = t.length();
        
        boolean[] pre = new boolean[n + 1];
        boolean[] cur = new boolean[n + 1];
        
        for (int row = m; row >= 0; --row) {
            for (int col = n; col >= 0; --col) {
                if (row == m && col == n) {
                    cur[col] = true;
                } else if (row == m) {
                    cur[col] = false;
                } else if (col == n) {
                    cur[col] = s.charAt(row) >= 'a' && pre[col];
                } else {
                    if (s.charAt(row) >= 'a') {
                        if (s.charAt(row) == t.charAt(col)) {
                            cur[col] = pre[col + 1] || pre[col];
                        } else {
                            cur[col] = pre[col];
                        }
                    } else {
                        if (s.charAt(row) == t.charAt(col)) {
                            cur[col] = pre[col + 1];
                        } else {
                            cur[col] = false;
                        }
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