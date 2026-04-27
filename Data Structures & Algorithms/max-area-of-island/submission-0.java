class Solution {
    int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    maxArea = Math.max(maxArea, dfs(r,c,grid,visited));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] visited) {
        visited[r][c] = true;
        int area = 1;

        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == 1 && !visited[nr][nc]) {
                area += dfs(nr, nc, grid, visited);
            }
        }

        return area;
    }
}
