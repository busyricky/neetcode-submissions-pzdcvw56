class Solution {
    int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
    int ROWS = 0, COLS = 0;

    int currOriginRow;
    int currOriginCol;
    Set<Pair<Integer,Integer>> currIsland;

    public int numDistinctIslands(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int[][] visited = new int[ROWS][COLS];
        Set<Set<Pair<Integer,Integer>>> islands = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (visited[r][c] == 0 && grid[r][c] == 1) {
                    currOriginRow = r;
                    currOriginCol = c;
                    currIsland = new HashSet<>();
                    dfs(grid, visited, r, c);
                    islands.add(currIsland);
                } else {
                    visited[r][c] = 1;
                }
            }
        }

        return islands.size();
    }

    private void dfs(int[][] grid, int[][] visited, int r, int c) {
        visited[r][c] = 1;

        for (int[] dirs : DIRS) {
            int nr = r + dirs[0];
            int nc = c + dirs[1];

            if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && visited[nr][nc] == 0 && grid[nr][nc] == 1) {
                currIsland.add(new Pair<>(nr - currOriginRow, nc - currOriginCol));
                dfs(grid, visited, nr, nc);
            }
        }
    }
}
