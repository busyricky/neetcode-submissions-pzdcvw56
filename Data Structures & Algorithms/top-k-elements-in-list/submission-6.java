class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> heap = new PriorityQueue<>((a,b) -> (Integer.compare(a[1],b[1])));

        for (int num : map.keySet()) {
            int[] freq = new int[]{num, map.get(num)};  // [number, frequency]

            heap.add(freq);

            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] resp = new int[k];

        for (int i = 0; i < k; i++) {
            resp[i] = heap.remove()[0];
        }

        return resp;
    }
}
