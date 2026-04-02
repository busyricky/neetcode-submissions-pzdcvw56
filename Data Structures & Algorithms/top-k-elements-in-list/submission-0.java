class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> sortedValueList = new ArrayList<>(map.values());
        Collections.sort(sortedValueList);

        while (sortedValueList.size() > k) {
            sortedValueList.remove(0);
        }

        // Set<Integer> sortedValueSet = new HashSet<>();
        // for (Integer value : sortedValueList) {
        //     sortedValueSet.put(value);
        // }


        int[] responseArr = new int[k];
        int i = 0;

        for (int currKey : map.keySet()) {
            int currValue = map.get(currKey);

            if (i >= k) {
                break;
            }

            if (sortedValueList.contains(currValue)) {
                responseArr[i] = currKey;
                i++;
            }
        }

        return responseArr;
    }
}
