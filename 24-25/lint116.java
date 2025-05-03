public class Solution {
    /**
     * @param a: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] a) {
        // write your code here
        final int n = a.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; i+j <= n -1; j++) {
                if (j <= a[i] && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}