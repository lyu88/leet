class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int index = 0; index <= i - 1; index++) {
                sum += dp[index] * dp[i - 1 - index];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}