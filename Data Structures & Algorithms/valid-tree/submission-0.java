class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return dfs(0, visited, map, -1) ? allVisited(visited) : false;
    }

    private boolean dfs(int curr, boolean[] visited, Map<Integer,List<Integer>> map, int parent) {
        if (visited[curr]) {
            return false;
        }

        visited[curr] = true;

        for (int nei : map.get(curr)) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(nei, visited, map, curr)) {
                return false;
            }
        }

        return true;
    }

    private boolean allVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
