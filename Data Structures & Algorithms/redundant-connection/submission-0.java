class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= edges.length; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            boolean[] visited = new boolean[edges.length + 1];
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            if (!dfs(edge[0], -1, map, visited)) {
                return edge;
            }
        }

        return new int[2];
    }

    private boolean dfs(int curr, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }
        visited[curr] = true;

        for (int nei : map.get(curr)) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(nei, curr, map, visited)) {
                return false;
            }
        }

        return true;
    }
}
