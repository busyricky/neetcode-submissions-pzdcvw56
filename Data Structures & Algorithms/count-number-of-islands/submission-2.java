class Solution {
    int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(r,c,grid,visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == '1' && !visited[nr][nc]) {
                dfs(nr, nc, grid, visited);
            }
        }
    }
}
