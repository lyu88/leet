class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i != m && j != n) {
                    if (nums1[i] == nums2[j]) {
                        if (i + 1 < m && j + 1 < n && nums1[i+1] == nums2[j+1]) {
                            dp[i][j] = dp[i+1][j+1] + 1;
                        } else dp[i][j] = 1;
                         max = Math.max(max, dp[i][j]);
                    } 
                }
            }
        }
        return max;
    }
}