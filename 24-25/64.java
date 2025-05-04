class Solution {
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    res[j] = grid[0][0];
                } else if (i == 0) {
                    res[j] = res[j-1] + grid[0][j];
                } else if (j == 0) {
                    res[j] += grid[i][j];
                } else {
                    res[j] = grid[i][j] + Math.min(res[j - 1], res[j]);
                }
            }
        }
        return res[n - 1];
    }
}