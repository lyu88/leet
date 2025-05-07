public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        int ret = 0;
        final int m = grid.length;
        if (m == 0) {
            return 0;
        }
        final int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ret += dfs(i,j, grid, visited);
            }
        }
        return ret;
    }

    private int dfs(int i, int j, boolean[][] grid, boolean[][] visited) {
        final int m = grid.length;
        final int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || !grid[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        dfs(i+1, j, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j+1, grid, visited);
        dfs(i, j-1, grid, visited);
        return 1;
    }
}