class Solution {
    // boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        // visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (helper(board,r,c,word,1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int r, int c, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        char ch = word.charAt(idx);

        //right
        if (c+1 < board[r].length && board[r][c+1] != '#' && ch == board[r][c+1] && helper(board,r,c+1,word,idx+1)) {
            return true;
        }
        //left
        if (c-1 >= 0 && board[r][c-1] != '#' && ch == board[r][c-1] && helper(board,r,c-1,word,idx+1)) {
            return true;
        }
        //top
        if (r-1 >= 0 && board[r-1][c] != '#' && ch == board[r-1][c] && helper(board,r-1,c,word,idx+1)) {
            return true;
        }
        //down
        if (r+1 < board.length && board[r+1][c] != '#' && ch == board[r+1][c] && helper(board,r+1,c,word,idx+1)) {
            return true;
        }

        board[r][c] = temp;

        return false;
    }
}
