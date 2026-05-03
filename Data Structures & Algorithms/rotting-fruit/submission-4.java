class Solution {
    public int orangesRotting(int[][] grid) {
        int ffRemaining = 0, minutes = 0;
        int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> qu = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    ffRemaining++;
                } else if (grid[r][c] == 2) {
                    qu.offer(new int[]{r,c});
                }
            }
        }

        while (ffRemaining != 0) {
            int size = qu.size(), temp = ffRemaining;

            for (int i = 0; i < size; i++) {
                int[] rot = qu.poll();
                for (int[] dir : DIRS) {
                    int nr = rot[0] + dir[0];
                    int nc = rot[1] + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        qu.offer(new int[]{nr,nc});
                        ffRemaining--;
                    }
                }
            }

            if (ffRemaining == temp) {
                return -1;
            }

            minutes++;
        }

        return minutes;
    }
}
