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

// bfs
class Solution {
    public int numIslands(char[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ret++;
                    bfs(grid, i,j, visited);
                }
            }
        }
        return ret;
    }

    void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        final int m = grid.length;
        final int n = grid[0].length;
        Queue<Integer> rowQue = new ArrayDeque<>();
        Queue<Integer> colQue = new ArrayDeque<>();
        rowQue.add(i); colQue.add(j);
        while (!rowQue.isEmpty()) {
            int row = rowQue.poll();
            int col = colQue.poll();
            if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == '0') {
                continue;
            }
            visited[row][col] = true;
            rowQue.add(row + 1); colQue.add(col);
            rowQue.add(row - 1); colQue.add(col);
            rowQue.add(row); colQue.add(col + 1);
            rowQue.add(row); colQue.add(col - 1);
        }
    }
}