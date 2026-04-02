class Solution {
    int[][] subGridLocations = {{0,0}, {0,3}, {0,6}, {3,0}, {3,3}, {3,6}, {6,0}, {6,3}, {6,6}};

    public boolean isValidSudoku(char[][] board) {
        boolean response = true;
        int[] numSet = new int[9];

        int length = board.length;

        //check all rows
        for (int i = 0; i < length; i++) {
            numSet = new int[9];
            for (int j = 0; j < length; j++) {
                int currVal = board[i][j] - '0' - 1;
                if (board[i][j] != '.' && numSet[currVal] != 0) {
                    return false;
                } else if (board[i][j] != '.') {
                    numSet[currVal] = 1;
                }
            }
        }

        //check all columns
        for (int i = 0; i < length; i++) {
            numSet = new int[9];
            for (int j = 0; j < length; j++) {
                int currVal = board[j][i] - '0' - 1;
                if (board[j][i] != '.' && numSet[currVal] != 0) {
                    return false;
                } else if (board[j][i] != '.') {
                    numSet[currVal] = 1;
                }
            }
        }

        //check all sub-grids
        for (int[] subGridLocation: subGridLocations) {
            numSet = new int[9];
            int rowMax = subGridLocation[0] + 3, colMax = subGridLocation[1] + 3;
            for (int i = subGridLocation[0]; i < rowMax; i++) {
                for (int j = subGridLocation[1]; j < colMax; j++) {
                    int currVal = board[i][j] - '0' - 1;
                    if (board[i][j] != '.' && numSet[currVal] != 0) {
                        return false;
                    } else if (board[i][j] != '.') {
                        numSet[currVal] = 1;
                    }
                }
            }
        }

        return response;
    }
}
