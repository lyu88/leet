public class Solution {
    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        // write your code here
        return validRows(board) && validCols(board) && validBlocks(board);
    }

    boolean validRows(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean[] res = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char c = board[row][i];
                if (c == '.') {
                    continue;
                }
                if (res[c - '1']) {
                    return false;
                }
                res[c - '1'] = true;
            }
        }
        return true;
    }

    boolean validCols(char[][] board) {
        for (int col = 0; col < 9; col++) {
            boolean[] res = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char c = board[i][col];
                if (c == '.') {
                    continue;
                }
                if (res[c - '1']) {
                    return false;
                }
                res[c - '1'] = true;
            }
        }
        return true;
    }

    boolean validBlocks(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] res = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[row+i][col+j];
                        if (c == '.') {
                            continue;
                        }
                        if (res[c - '1']) {
                            return false;
                        }
                        res[c - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}