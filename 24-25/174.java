class Solution {
    public int calculateMinimumHP(int[][] d) {
        final int m = d.length;
        final int n = d[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = calc(1, d[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = calc(dp[i][j+1], d[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = calc(dp[i + 1][j], d[i][j]);
                } else {
                    dp[i][j] = Math.min(calc(dp[i][j+1], d[i][j]), calc(dp[i + 1][j], d[i][j]));
                }
            }
        }
        return dp[0][0];
    }

    int calc(int health, int points) {
       return Math.max( health - points, 1);
    }
}