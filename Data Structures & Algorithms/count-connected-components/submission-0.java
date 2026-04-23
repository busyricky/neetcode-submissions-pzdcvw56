class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            dfs(i, map, visited);

            counter++;
        }

        return counter;
    }

    private void dfs(int node, Map<Integer,List<Integer>> map, boolean[] visited) {
        visited[node] = true;

        for (int nei : map.get(node)) {
            if (!visited[nei]) {
                dfs(nei, map, visited);
            }
        }
    }
}
