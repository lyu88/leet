
// TLE if I just reuse the problem 121 to buy once
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            int max = prices[i] - min + maxProfit(prices, i);
            ret = Math.max(ret, max);
        }
        return ret;
    }


    int maxProfit(int[] prices, int left) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = left; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}


// dp 思考
class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        // 1st step of dp
        // 从这里砍一刀，往右看
        int[] dp = new int[n];
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], Math.max(0, max - prices[i]));
            max = Math.max(max, prices[i]);
        }
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            int res = prices[i] - min + dp[i];
            ret = Math.max(ret, res);
        }
        return ret;
    }
}