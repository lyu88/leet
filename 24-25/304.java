class NumMatrix {

    int[][] sum; 

    public NumMatrix(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        List<List<Integer>> rowSums = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            List<Integer> list = new ArrayList<>();
            int presum = 0;
            for (int col = 0; col < n; col++) {
                presum += matrix[row][col];
                list.add(presum);
            }
            rowSums.add(list);
        }
        sum = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0) {
                    sum[row][col] = rowSums.get(row).get(col);
                } else {
                    sum[row][col] = rowSums.get(row).get(col) + sum[row-1][col];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = sum[row2][col2];
        int min1 = 0;
        if (col1 > 0) {
            min1 = sum[row2][col1 - 1];
        }
        int min2 = 0;
        if (row1 > 0) {
            min2 = sum[row1 - 1][col2];
        }
        int add = 0;
        if (row1 > 0 && col1 > 0) {
            add = sum[row1 - 1][col1 - 1];
        }
        return ret + add - min1 - min2;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */