class Solution {
    int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i,j,grid,visited,sb);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    private void dfs(int r, int c, int[][] grid, boolean[][] visited, StringBuilder sb) {
        visited[r][c] = true;

        char ch = 'a';

        for (int[] dir : DIRS) {
            int nr = r + dir[0], nc = c + dir[1];

            if (nr < grid.length && nr >= 0 && nc < grid[nr].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] == 1) {
                sb.append(ch);
                dfs(nr, nc, grid, visited, sb);
            }
            ch++;
        }

        sb.append('z');
    }
}
