class Solution {
    int ROWS;
    int COLS;
    int[][] DIRS = {{0,1},{0,-1},{-1,0},{1,0}};

    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> qu = new LinkedList<>();
        int minutes = 0;
        int fresh = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    qu.offer(new int[]{r,c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        while (!qu.isEmpty() && fresh != 0) {
            int rotted = qu.size();

            for (int i = 0; i < rotted; i++) {
                int[] rot = qu.poll();

                for (int[] dir : DIRS) {
                    int nr = rot[0] + dir[0];
                    int nc = rot[1] + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        qu.offer(new int[]{nr,nc});
                    }
                }
            }

            minutes++;
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}
