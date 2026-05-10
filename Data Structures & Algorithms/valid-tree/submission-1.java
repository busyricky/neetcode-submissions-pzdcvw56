class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] processed = new boolean[n];
        if (!dfs(processed, map, 0, -1)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!processed[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(boolean[] processed, Map<Integer, List<Integer>> map, int node, int parent) {
        if (processed[node]) {
            return false;
        }

        processed[node] = true;

        for (int nei : map.get(node)) {
            if (nei != parent) {
                if (!dfs(processed, map, nei, node)) {
                    return false;
                }
            }
        }

        return true;
    }
}
