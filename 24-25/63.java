class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        final int m = g.length;
        final int n = g[0].length;
        int[][] dp = new int[m][n];
        if (g[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) {
                    continue;
                }         
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] == 0 ? 0 : 1;
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] == 0 ? 0 : 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}