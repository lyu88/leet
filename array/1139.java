class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    up[i][j] = i > 0 ? up[i - 1][j] + 1 : 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = Math.min(i + 1, j + 1);
                for (int k = 0; k < len; k++) {
                    if (up[i][j] > k && left[i][j] > k
                        && left[i - k][j] > k && up[i][j - k] > k) {
                            max = Math.max(max, (k+1)*(k + 1));
                    }
                }
            }
        }
        return max;
    }
}