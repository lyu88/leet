class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        final int m = grid.length;
        final int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += dfs(grid, i, j, visited);
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int i, int j, boolean[][] visited) {
        final int m = grid.length;
        final int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0') {
            return 0;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
        return 1;
    }
}