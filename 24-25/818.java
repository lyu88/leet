class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            int k = (int) (Math.log(i + 1) / Math.log(2));
            if (isPowerOfTwoMinusOne(i)) {
                dp[i] = k;
            } else {
                int preStop = (int)Math.pow(2, k) - 1;
                int nextStop = (int)Math.pow(2, k + 1) - 1;
                dp[i] = k + 2 + dp[nextStop - i];
                for (int r = 1; r <= k; r++) {
                    int distance = (int)Math.pow(2, r - 1) - 1;
                    dp[i] = Math.min(dp[i], k + r + 1 + dp[i - preStop + distance]);
                }
            }
        }
        return dp[target];
    }

    private boolean isPowerOfTwoMinusOne (int n) {
        return (n & (n + 1)) == 0;
    }
}