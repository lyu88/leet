class Solution {

	public int longestPalindromeSubseq(String s) {
        
    }

	
    private int longestPalindromeSubstring(String s) {
    	final int len = s.length();
    	int max = 1;
        boolean[][] dp = new boolean[len][len];
        for (int center = 0; center < len; center++) {
        	dp[center][center] = true; 
        	int begin = center - 1, end = center + 1;
        	while (begin >= 0 && end < len) {
        		if (s.charAt(begin) == s.charAt(end)) {
        			dp[begin][end] = true;
        			max = Math.max(max, end - begin + 1);
        			begin--;
        			end++;
        			
        		} else {
        			break;
        		}

        	}
        }
        for (int center = 0; center < len; center++) {
        	int begin = center, end = center + 1;
        	while (begin >= 0 && end < len) {
        		if (s.charAt(begin) == s.charAt(end)) {
        			dp[begin][end] = true;
        			max = Math.max(max, end - begin + 1);
        			begin--;
        			end++;
        			
        		} else {
        			break;
        		}

        	}
        }
        return max;
    }
}