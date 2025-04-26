class Solution {

    int[][] moves = {{-1, 2}, {-2, 1}, {-2, -1}, {-1,-2}, {1, -2}, {2, -1}, {2,1}, {1,2}};

    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] memo = new Double[n][n][k + 1];
        return dfs(k, n, row, column, memo);
    }

    private double dfs(int k, final int n, int row, int col, Double[][][] memo) {
        if (row < 0 || row >= n || col < 0 || col >= n || k < 0) {
            return 0;
        }
        if (memo[row][col][k] != null) {
            return memo[row][col][k];
        }
        if (k == 0) {
            memo[row][col][k] = 1.0;
            return 1;
        } 
        double prob = 0.0;
        for (int[] move : moves) {
            prob += dfs(k-1, n, row + move[0], col + move[1], memo);
        }
        prob /= 8;
        memo[row][col][k] = prob;
        return prob;
    }
}