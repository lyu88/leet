class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int n = books.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + books[i][1];
            int width = books[i][0];
            int height = books[i][1];
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + height);
            }
        }
        return dp[n];
    }
}