class Solution {
    public void gameOfLife(int[][] board) {
        int[] neighbor = new int[]{0, -1, 1};
        int row = board.length;
        int col = board[0].length;
        int[][] sub = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                sub[i][j] = board[i][j];
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int live = 0;
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        if (!(p == 0 && q == 0)) {
                            if (i+neighbor[p] >= 0 && i+neighbor[p] < row && j+neighbor[q] >= 0 && j+neighbor[q] < col && sub[i+neighbor[p]][j+neighbor[q]] == 1) {
                                live++;
                            }
                        }
                    }
                }
                if (sub[i][j] == 1 && (live < 2 || live >3)) {
                    board[i][j] = 0;
                } else if (sub[i][j] == 0 && live == 3){
                    board[i][j] = 1;
                }
            }
        }
            
    }
}
