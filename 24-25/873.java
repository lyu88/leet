class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        final int len = arr.length;
        int dp[][] = new int[len][len];
        int max = 0;
        for (int i = 2; i < len; i++) {
            int val = arr[i];
            int left = 0, right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] == val) {
                    dp[right][i] = dp[left][right] == 0 ? 3 :  dp[left][right] + 1;
                    max = Math.max(max, dp[right][i]);
                    left++;
                    right--;
                } else if (arr[left] + arr[right] < val) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return max;
    }
}