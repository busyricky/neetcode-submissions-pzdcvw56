class Solution {
    int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];

                if (c == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;

        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < visited.length && nc < visited[nr].length && !visited[nr][nc] && grid[nr][nc] == '1') {
                dfs(grid, visited, nr, nc);
            }
        }
    }
}
