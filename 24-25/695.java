class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {         
                    max = Math.max(max, bfs(grid, i,j, visited));
                }
            }
        }
        return max;
    }

    int bfs(int[][] grid, int i, int j, boolean[][] visited) {
        final int m = grid.length;
        final int n = grid[0].length;
        Queue<Integer> rowQue = new ArrayDeque<>();
        Queue<Integer> colQue = new ArrayDeque<>();
        rowQue.add(i); colQue.add(j);
        int ret = 0;
        while (!rowQue.isEmpty()) {
            int row = rowQue.poll();
            int col = colQue.poll();
            if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
                continue;
            }
            visited[row][col] = true;
            ret++;
            rowQue.add(row + 1); colQue.add(col);
            rowQue.add(row - 1); colQue.add(col);
            rowQue.add(row); colQue.add(col + 1);
            rowQue.add(row); colQue.add(col - 1);
        }
        return ret;
    }
}