public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param a: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] a) {
        // write your code here
        final int n = a.length;
        int[][] dp = new int[n][m+1];
        for (int i = a[0]; i <=m; i++) {
            dp[0][i] = a[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= a[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-a[i]] + a[i]);
                }
            }
        }
        return dp[n-1][m];
    }
}