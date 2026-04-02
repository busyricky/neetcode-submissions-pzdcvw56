class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // using O(n) time and space - array
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqList = new List[nums.length + 1];

        for (int i = 0; i < freqList.length; i++) {
            freqList[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            freqList[entry.getValue()].add(entry.getKey());
        }

        int[] responseArr = new int[k];

        int responseArrCounter = 0;
        for (int i = freqList.length - 1; i > 0 && responseArrCounter < k; i--) {
            for (Integer key : freqList[i]) {
                responseArr[responseArrCounter] = key;
                responseArrCounter++;

                if(responseArrCounter == k) {
                    return responseArr;
                }
            }
        }

        return responseArr;
    }
}
