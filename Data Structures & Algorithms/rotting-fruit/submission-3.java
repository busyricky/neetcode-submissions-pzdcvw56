class Solution {
    int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int orangesRotting(int[][] grid) {
        int minutes = 0, freshFruit = 0;

        Queue<int[]> rottenFruit = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottenFruit.add(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    freshFruit++;
                }
            }
        }

        while (freshFruit > 0) {
            int temp = freshFruit, size = rottenFruit.size();
            
            for (int i = 0; i < size; i++) {
                int[] rFruit = rottenFruit.poll();
                for (int[] dir : DIRS) {
                    int nr = rFruit[0] + dir[0], nc = rFruit[1] + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshFruit--;
                        rottenFruit.add(new int[]{nr,nc});
                    }
                }
            }

            if (temp == freshFruit) {
                return -1;
            }

            minutes++;
        }

        return minutes;
    }
}
