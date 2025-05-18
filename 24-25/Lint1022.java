public class Solution {
    /**
     * @param board: the given board
     * @return: True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game
     */
    public boolean validTicTacToe(String[] board) {
        // Write your code
        int xCount = 0;
        int oCount = 0;

        // Count Xs and Os
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                else if (c == 'O') oCount++;
            }
        }

        // O cannot be more than X, and X cannot be more than one extra than O
        if (oCount > xCount || xCount - oCount > 1) return false;

        boolean xWin = isWin(board, 'X');
        boolean oWin = isWin(board, 'O');

        // Both players can't win
        if (xWin && oWin) return false;

        // If X wins, must be one more X than O
        if (xWin && xCount != oCount + 1) return false;

        // If O wins, must be equal number of X and O
        if (oWin && xCount != oCount) return false;

        return true;
    }

    private boolean isWin(String[] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player &&
                board[i].charAt(1) == player &&
                board[i].charAt(2) == player) return true;
            if (board[0].charAt(i) == player &&
                board[1].charAt(i) == player &&
                board[2].charAt(i) == player) return true;
        }

        // Check diagonals
        if (board[0].charAt(0) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(2) == player) return true;
        if (board[0].charAt(2) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(0) == player) return true;

        return false;
    }
}