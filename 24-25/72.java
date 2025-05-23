class Solution {
    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    dp[m][n] = 0;
                } else if (i == m) {
                    dp[m][j] =  dp[m][j + 1] + 1;
                } else if (j == n) {
                    dp[i][n] = dp[i+1][n] + 1;
                } else {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1];
                    } else {
                        dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j])) + 1;
                    }
                }
            }
        }
        return dp[0][0];
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        int[] pre = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int j = m -1; j >= 0; j--) {
            pre[j] = pre[j + 1] + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            cur[m] = pre[m] + 1;
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    cur[j] = pre[j + 1];
                } else {
                    cur[j] = 1 + Math.min(pre[j + 1], Math.min(pre[j], cur[j + 1]));
                }
            }
            int[] tmp = pre;
            pre = cur;
            cur = tmp;
        }
        return pre[0];
    }
}