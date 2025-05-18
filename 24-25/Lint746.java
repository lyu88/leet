class TicTacToe {

    /** Initialize your data structure here. */
    int xCount;
    int oCount;
    boolean winState;
    char[][] board;

    public TicTacToe() {
        xCount = 0;
        oCount = 0;
        board = new char[3][3];
    }
    
    public boolean move(int row, int col) throws GameEndException, AlreadyTakenException {
        if (winState) {
            throw new GameEndException();
        }
        if (board[row][col] != 0) {
            throw new AlreadyTakenException();
        }
        if (xCount == oCount) {
            board[row][col] = 'X';
            xCount++;
        } else {
            board[row][col] = 'O';
            oCount++;
        }

        if (isWin(board, 'X') || isWin(board, 'O')) {
            winState = true;
            return true;
        }
        return false;
    }

    private boolean isWin(char[][] board, char player) {
    // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) return true;
            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) return true;
        }

        // Check diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) return true;
        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) return true;

        return false;
    }
}

 class GameEndException extends Exception{
    public GameEndException()
    {
        super("Game has been ended, cannot make any more moves");
    }
}

 class AlreadyTakenException extends Exception {
    public AlreadyTakenException()
    {
        super("This place has been taken");
    }
}


