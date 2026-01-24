class Solution {
    private boolean helper(char[][] board, String word, int index, int i, int j, int m, int n) {
        if(board[i][j] != word.charAt(index)) return false;

        if(index == word.length() - 1) return true;

        char cur = word.charAt(index);
        board[i][j] = ' ';

        boolean ans = false;
        // top
        if(i - 1 >= 0) ans = ans || helper(board, word, index + 1, i - 1, j, m, n);
        // right
        if(j + 1 < m) ans = ans || helper(board, word, index + 1, i, j + 1, m, n);
        // bottom
        if(i + 1 < n) ans = ans || helper(board, word, index + 1, i + 1, j, m, n);
        // left
        if(j - 1 >= 0) ans = ans || helper(board, word, index + 1, i, j - 1, m, n);

        board[i][j] = cur;

        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(helper(board, word, 0, i, j, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}