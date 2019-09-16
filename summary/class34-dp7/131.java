class Solution {
    public List<List<String>> partition(String s) {
        final int len = s.length();
        List<List<String>> allRes = new ArrayList<>();
        if (len == 0) {
            return allRes;
        }
        
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len - 1; i++) {
        	isPal[i][i] = true;
            int j = i;
            int k = i + 1;
            while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
                isPal[j][k] = true;
                j--;
                k++;
            }
        }
        isPal[len - 1][len - 1] = true;
        for (int i = 1; i < len - 1; i++) {
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
                isPal[j][k] = true;
                j--;
                k++;
            }
        }
        
        dfs(s, 0, isPal, allRes, new ArrayList<String>());
        return allRes;
    }

    private void dfs(String s, int index, boolean[][] isPal, List<List<String>> allRes, List<String> path) {
    	if (index == s.length()) {
    		allRes.add(new ArrayList<String>(path));
    	}
    	for (int i = index; i < s.length(); i++) {
    		if (isPal[index][i]) {
    			path.add(s.substring(index, i + 1));
    			dfs(s, i + 1, isPal, allRes, path);
    			path.remove(path.size() - 1);
    		}
    	}
    }
}