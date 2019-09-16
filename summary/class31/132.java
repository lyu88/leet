class Solution {
    public int minCut(String s) {
 		final int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len - 1; i++) {
            int j = i;
            int k = i + 1;
            while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
                isPal[j][k] = true;
                j--;
                k++;
            }
        }
        count += len;
        for (int i = 1; i < len - 1; i++) {
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
                isPal[j][k] = true;
                j--;
                k++;
            }
        }

        int[] res = new int[len];
        res[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
        	if (isPal[i][len - 1]) {
        		res[i] = 0;
        		continue;
        	}
        	int min = 1;
        	for (int j = i; j < len - 1; j++) {
        		if (isPal[i][j]) {
        			min = Math.min(min, 1 + res[j + 1])
        		}
        	}
        	res[i] = min;
        }
        return res[0];
    }
}