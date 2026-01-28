class Solution {
    private boolean isSafe(int row, int col, int n, List<String> board) {
        int r = row, c = col;
        // upwards
        while(row >= 0) {
            if(board.get(row).charAt(col) == 'Q') return false;
            row--;
        }
        row = r;
        col = c;
        // upper diagonal right
        while(row >= 0 && col < n) {
            if(board.get(row).charAt(col) == 'Q') return false;
            row--; col++;
        }
        row = r;
        col = c;
        // upper diagonal left
        while(row >= 0 && col >= 0) {
            if(board.get(row).charAt(col) == 'Q') return false;
            row--; col--;
        }
        return true;
    }
    private void func(int row, int n, List<String> board, List<List<String>> ans) {
        if(row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int col = 0 ; col < n ; col++) {
            if(isSafe(row, col, n, board)) {
                StringBuilder str = new StringBuilder(board.get(row));
                // place queen
                str.setCharAt(col, 'Q');
                board.set(row, str.toString());

                // recursively place queen in next rows
                func(row + 1, n, board, ans);

                // remove queen and backtrack
                str.setCharAt(col, '.');
                board.set(row, str.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            board.add(".".repeat(n));
        }

        func(0, n, board, ans);

        return ans;
    }
}