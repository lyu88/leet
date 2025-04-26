// runtime 1348s, which seems too long
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int max = 1;
        for (int row = 0; row < m; row ++) {
            for (int col = 0; col < n; col++) {
                max = Math.max(max, dfs(row, col, matrix, new Integer[m][n], new boolean[m][n]));
            }
        }
        return max;
    }

    int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};

    private int dfs(int row, int col, int[][] matrix, Integer[][] allRes, boolean[][] visited) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        
        if (allRes[row][col] != null) {
            return allRes[row][col];
        }
        int ret = 1;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]
                || matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            }
            ret = Math.max(ret, 1 + dfs(newRow, newCol, matrix, allRes, visited));
        }
        visited[row][col] = false;
        allRes[row][col] = ret;
        return ret;
    }
}

// solution in 2024
// 以该节点为开头的结论memo
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int max = 1;
        int[][] memo = new int[m][n];
        for (int row = 0; row < m; row ++) {
            for (int col = 0; col < n; col++) {
                max = Math.max(max, dfs(row, col, matrix, memo));
            }
        }
        return max;
    }

    int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};

    private int dfs(int row, int col, int[][] matrix, int[][] memo) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        
        if (memo[row][col] > 0) {
            return memo[row][col];
        }
        int ret = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n 
                || matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            }
            ret = Math.max(ret, 1 + dfs(newRow, newCol, matrix, memo));
        }
        memo[row][col] = ret;
        return ret;
    }
}