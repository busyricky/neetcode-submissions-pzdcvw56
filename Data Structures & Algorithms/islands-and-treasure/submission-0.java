class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    qu.add(new int[]{r,c});
                }
            }
        }

        int dist = 1;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int[] curr = qu.poll();

                for (int[] dirs : DIRS) {
                    int nr = curr[0] + dirs[0];
                    int nc = curr[1] + dirs[1];

                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 2147483647) {
                        grid[nr][nc] = dist;
                        qu.offer(new int[]{nr,nc});
                    }
                }
            }

            dist++;
        }
    }
}
