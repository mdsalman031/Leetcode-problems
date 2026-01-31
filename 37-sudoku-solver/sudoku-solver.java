class Solution {
    private boolean isPossible(char[][] board, int row, int col, char digit) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = 0 ; i < 9 ; i++) {
            if(board[row][i] == digit) return false; // row check
            if(board[i][col] == digit) return false; // column check
            // 3 x 3 grid check
            if(board[startRow + (i / 3)][startCol + (i % 3)] == digit) return false;
        }
        return true;
    }
    private boolean func(char[][] board) {
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                if(board[i][j] == '.') {
                    for(char digit = '1' ; digit <= '9' ; digit++) {
                        if(isPossible(board, i, j, digit)) {
                            board[i][j] = digit;
                            if(func(board)) return true;
                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // no valid digit found
                }
            }
        }
        return true; // solved
    }
    public void solveSudoku(char[][] board) {
        func(board);
    }
}