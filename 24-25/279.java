class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int index = 2; index <= n; index++) {
            dp[index] = index;
            for (int i = 1; i * i <= index; i++) {
                dp[index] = Math.min(dp[index], 1 + dp[index - i*i]);
            }
        }
        return dp[n];
    }
}