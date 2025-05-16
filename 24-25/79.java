class Solution {
    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, word, board, i,j, new boolean[m][n])){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int index, String word, char[][] board, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        final int m = board.length;
        final int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean flag = 
        dfs(index + 1, word, board, i + 1, j, visited) 
        || dfs(index + 1, word, board, i - 1, j, visited) 
        || dfs(index + 1, word, board, i , j+1, visited) 
        || dfs(index + 1, word, board, i , j-1, visited) ;
        visited[i][j] = false;
        return flag;
    }
}