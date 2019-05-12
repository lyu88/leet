class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
    }

    /**
	* @param coins: a list of integer
	* @param amount: a total amount of money amount
	* @return: the fewest number of coins that you need to make up
    **/
    private int coinChange(int[] A, int M) {
    	int[] f = new int[M+1];
    	final int n = A.length;

    	f[0] = 0;
    	for (int i = 1; i <= M; ++i) {
    		f[i] = Integer.MAX_VALUE;
    		for (j = 0; j < n; ++j) {
    			if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE) {
    				f[i] = Math.min(f[i], f[i - A[j]] + 1);
    			}
    		}
    	}

    	
    	return f[M] == Integer.MAX_VALUE ? -1 : f[M];
    }


    public boolean wordBreak(String s, List<String> wordDict) {

        final int n = s.length();
        boolean[] allResults = new boolean[n + 1];

        allResults[n] = true;

        for (int i = n - 1; i >= 0; --i) {
            for (String word : wordDict) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len).equals(word)) {
                    if(allResults[i + len]) {
                        allResults[i] = true;
                        break;
                    }
                }
            }
        }
        return allResults[0];
    }
}