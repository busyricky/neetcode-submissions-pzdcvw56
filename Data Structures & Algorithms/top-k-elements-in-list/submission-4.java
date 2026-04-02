class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] response = new int[k];

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < nums.length + 1; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int key : map.keySet()) {
            buckets.get(map.get(key)).add(key);
        }

        int counter = 0;
        for (int i = buckets.size() - 1; i > 0; i--) {
            for (int num : buckets.get(i)) {
                response[counter] = num;
                counter++;

                if (counter == k) { return response; }
            }
        }

        return response;
    }
}
