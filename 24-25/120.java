class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        final int n = t.size();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == n - 1) {
                    dp[j] = t.get(n-1).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + t.get(i).get(j);
                }
            }
        }
        return dp[0];
    }
}