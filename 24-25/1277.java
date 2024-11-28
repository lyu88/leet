  class Solution {
    public int countSquares(int[][] a) {
        final int m = a.length;
        final int n = a[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = a[i][j];
                } else {
                    if (a[i][j] == 1) {
                        dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}