class Solution {
    public int minFallingPathSum(int[][] ma) {
        final int m = ma.length;
        final int n = ma[0].length;
        int[] pre = ma[0].clone();
        for (int i = 1; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                cur[j] = ma[i][j] + findMin(j - 1 < 0 ? Integer.MAX_VALUE : pre[j - 1],
                pre[j],
                j + 1 >= n ? Integer.MAX_VALUE : pre[j + 1]);
            }
            pre = cur;
        }
        return findMin(pre);
    }
    // this method makes it slow ?
    private int findMin(int... a) {
        return Arrays.stream(a).min().getAsInt();
    }
}