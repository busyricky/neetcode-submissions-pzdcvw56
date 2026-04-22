class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) { return new ArrayList<>(List.of(0)); }

        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> leaves = new LinkedList<>();

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int key : adjList.keySet()) {
            int connections = adjList.get(key).size();

            if (connections == 1) {
                leaves.add(key);
            }

            map.put(key, connections);
        }

        int remaining = n;

        while (remaining > 2) {
            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                for (int nei : adjList.get(leaf)) {
                    if (map.get(nei) - 1 == 1) {
                        leaves.add(nei);
                    }
                    map.put(nei, map.get(nei) - 1);
                }
                remaining--;
            }
        }

        List<Integer> resp = new ArrayList<>();
        while (!leaves.isEmpty()) {
            resp.add(leaves.poll());
        }

        return resp;
    }
}