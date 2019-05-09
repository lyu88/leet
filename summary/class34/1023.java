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