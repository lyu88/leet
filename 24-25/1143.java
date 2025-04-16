class Solution {
    public int longestCommonSubsequence(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    dp[m][n] = 0;
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}