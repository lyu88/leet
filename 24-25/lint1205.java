class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        final int n = matrix.length;
        final int m = matrix[0].length;
        int row = 0, col = 0;
        boolean direction = true; // 1 meaning up, 0 meaning down
        int index = 0;
        int[] res = new int[n*m];
        while (row < n && col < m) {
            res[index++] = matrix[row][col];
            int newRow = row + (direction ? -1:1);
            int newCol = col + (direction ? 1:-1);

            if (newRow < 0 || newRow == n || newCol < 0 || newCol == m) {
                if (direction) {
                    // either right or down
                    if (newCol == m) {
                        newRow = row + 1;
                        newCol = m - 1;
                    } else {
                        newRow = 0;
                    }
                } else {
                    // either down or right
                    if (newRow == n) {
                        newRow = n - 1;
                        newCol = col + 1;
                    } else {
                        newCol = 0;
                    }
                }
                direction = !direction;
            } 
            row = newRow;
            col = newCol;
        }
        return res;
    }

}