class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal1;
    private int diagonal2;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal1 = 0;
        diagonal2 = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        int n = rows.length;
        rows[row] += val;
        cols[col] += val;
        if (rows[row] == n * val || cols[col] == n * val) {
            return player;
        }
        //Two diagonals:
        if (row == col) {
            diagonal1 += val;
            if (diagonal1 == n * val) {
                return player;
            }
        }
        if (row == (n - 1 - col)) {
            diagonal2 += val;
            if (diagonal2 == n * val) {
                return player;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */