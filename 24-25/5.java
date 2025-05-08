class Solution {
    public String longestPalindrome(String s) {
        final int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0, end = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        end = j;
                        start = i;
                    }
                }
            }
            dp[j][j] = true;
        }
        return s.substring(start, end + 1);
    }
}