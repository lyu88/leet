class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        final int n = grid.length;
        int[] rows = new int[n];
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        return ret;
    }
}