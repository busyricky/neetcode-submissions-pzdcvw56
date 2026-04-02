class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] response = new int[k];

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            int max = -1, maxKey = -1;
            for (int key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    maxKey = key;
                }
            }
            response[i] = maxKey;
            map.remove(maxKey);
        }

        return response;
    }
}
