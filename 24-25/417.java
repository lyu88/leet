class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int m = heights.length;
        final int n = heights[0].length;
        boolean[][] visitedA = new boolean[m][n];
        boolean[][] visitedP = new boolean[m][n];
        for (int c = 0; c < n; c++) {
            dfs(heights, m - 1, c, visitedA);
            dfs(heights, 0, c, visitedP);
        }
        for (int r = 0; r < m; r++) {
            dfs(heights, r, n - 1, visitedA);
            dfs(heights, r, 0, visitedP);
        }
        List<List<Integer>> allRes = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visitedA[r][c] && visitedP[r][c]) {
                    allRes.add(List.of(r,c));
                }
            }
        }
        return allRes;
    }

    void dfs(int[][] matrix, int r, int c, boolean[][] visited) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        if (r + 1 < matrix.length && matrix[r+1][c] >= matrix[r][c]) {
            dfs(matrix, r+1, c, visited);
        }
        if (c + 1 < matrix[0].length && matrix[r][c+1] >= matrix[r][c]) {
            dfs(matrix, r, c+1, visited);
        }
        if (r - 1 >= 0 && matrix[r-1][c] >= matrix[r][c]) {
            dfs(matrix, r-1, c, visited);
        }
        if (c - 1 >= 0 && matrix[r][c-1] >= matrix[r][c]) {
            dfs(matrix, r, c-1, visited);
        }
    }
}