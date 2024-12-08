class Solution {
    public int numTilings(int n) {
        final int mod = 1_000_000_007;
        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            long x = 2L * dp[i - 1] + dp[i - 3];
            dp[i] = (int)(x % mod);
        }
        return dp[n];
    }
}