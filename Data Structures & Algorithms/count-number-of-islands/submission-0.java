class Solution {
    int[][] DIRS = {{0,1},{1,0},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int islandCount = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '0' || visited[r][c] == 1) {
                    visited[r][c] = 1;
                } else {
                    islandCount++;
                    dfs(grid, visited, r , c);
                }
            }
        }
        
        return islandCount;
    }

    private void dfs(char[][] grid, int[][] visited, int r, int c) {
        if (visited[r][c] == 1) {
            return;
        }
        
        visited[r][c] = 1;

        if (grid[r][c] == '1') {
            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (!(nr < 0 || nc < 0 || nr >= visited.length || nc >= visited[0].length || visited[nr][nc] == 1)) {
                    dfs(grid, visited, nr, nc);
                }
            }
        }
    }
}
