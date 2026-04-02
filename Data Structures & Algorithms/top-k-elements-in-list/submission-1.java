class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // using min heap
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[1] - b[1]));

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});

            if (minHeap.size() > k) { minHeap.poll(); }
        }

        int[] response = new int[k];
        int i = 0;

        for (int[] pair : minHeap) {
            response[i] = pair[0];
            i++;
        }

        return response;
    }
}
