public class Solution {
    /**
     * @param a: an integer array
     * @param v: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] a, int[] v, int m) {
        // write your code here
        final int n = a.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - a[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j - a[i - 1]] + v[i-1], dp[i][j - a[i - 1]] + v[i-1]));
                }
            }
        }
        return dp[n][m];
    }
}