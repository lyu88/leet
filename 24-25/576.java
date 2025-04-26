class Solution {

    int mod = 1_000_000_007;


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] memo = new Integer[m][n][maxMove + 1];
        return dfs(m,n,maxMove, startRow, startColumn, memo);
    }

    private int dfs(final int m, final int n, int k, int row, int col, Integer[][][] memo) {
        if (k < 0) {
            return 0;
        }
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        if (memo[row][col][k] != null) {
            return memo[row][col][k];
        }
        int ret = 0;
        ret = (ret + dfs(m,n,k-1,row + 1, col, memo))%mod;
        ret = (ret + dfs(m,n,k-1,row - 1, col, memo))%mod;
        ret = (ret + dfs(m,n,k-1,row , col + 1, memo))%mod;
        ret = (ret + dfs(m,n,k-1,row , col - 1, memo))%mod;
        memo[row][col][k] = ret;
        return ret;
    }
}