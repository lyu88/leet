public class Solution {
    /**
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    public int change(int m, int[] coins) {
        // write your code here
        final int n = coins.length;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i-1]; j <= m; j++) {
                dp[j] += dp[j - coins[i-1]];
            }
        }
        return dp[m];
    }
}