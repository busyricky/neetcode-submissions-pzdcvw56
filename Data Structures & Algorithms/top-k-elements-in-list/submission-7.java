class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> (Integer.compare(a[1],b[1])));

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);

            heap.add(new int[]{key, freq});

            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] resp = new int[heap.size()];

        for (int i = 0; i < resp.length; i++) {
            resp[i] = heap.remove()[0];
        }

        return resp;
    }
}
