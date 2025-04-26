class Solution {
    int mod = 1_000_000_007;

    int[][] dial = {{1,2,3}, {4,5,6}, {7,8,9}, {-1, 0, -1}};

    int[][] moves = {{-1, 2}, {-2, 1}, {-2, -1}, {-1,-2}, {1, -2}, {2,-1}, {2,1}, {1,2}};

    public int knightDialer(int n) {
        int[][][] memo = new int[4][3][n];
        int ret = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                ret = (ret + dfs(n-1, row, col, memo))%mod;
            }
        }
        return ret;
    }

    private int dfs(int k, int row, int col, int[][][] memo) {
        if (k < 0 || row < 0 || row > 3 || col < 0 || col > 2) {
            return 0;
        }
        if (memo[row][col][k] > 0) {
            return memo[row][col][k];
        }
        if (dial[row][col] == -1) {
            memo[row][col][k] = 0;
            return 0;
        }
        if (k == 0) {
            memo[row][col][k] = 1;
            return 1;
        }
        int ret = 0;
        for (int[] move : moves) {
            ret = (ret + dfs(k-1, row + move[0], col + move[1], memo))%mod;
        }
        memo[row][col][k] = ret;
        return ret;
    }
}