class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) { return List.of(0); }

        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> qu = new LinkedList<>();
        int[] edgeCount = new int[n];
        int remain = n;

        for (int node : map.keySet()) {
            if (map.get(node).size() == 1) {
                qu.offer(node);
            }
            edgeCount[node] = map.get(node).size();
        }

        while (remain > 2) {
            int size = qu.size();
            remain -= size;

            for (int i = 0; i < size; i++) {
                int curr = qu.poll();
                for (int nei : map.get(curr)) {
                    edgeCount[nei]--;
                    if (edgeCount[nei] == 1) {
                        qu.offer(nei);
                    }
                }
                edgeCount[curr] = 0;
            }
        }

        return new ArrayList<>(qu);
    }
}