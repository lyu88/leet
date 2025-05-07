public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param a: Given n items with size A[i]
     * @param v: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] a, int[] v) {
        // write your code here
        final int n = a.length;
        int[][] dp = new int[n][m+1];
        for (int i = a[0]; i <=m; i++) {
            dp[0][i] = v[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= a[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-a[i]] + v[i]);
                }
            }
        }
        return dp[n-1][m];
    }
}

// save space
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param a: Given n items with size A[i]
     * @param v: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] a, int[] v) {
        // write your code here
        final int n = a.length;
        int[] cur = new int[m + 1];
        int[] pre = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                cur[j] = pre[j];
                if (j >= a[i-1])
                    cur[j] = Math.max(cur[j], pre[j - a[i - 1]] + v[i-1]);
            }
            int[] tmp = pre;
            pre = cur;
            cur = tmp;
        }
        return pre[m];
    }
}