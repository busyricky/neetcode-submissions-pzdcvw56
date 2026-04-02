class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int highestFreq = 0;

        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            highestFreq = Math.max(highestFreq, freq);

            map.put(num, freq);
        }

        List<Integer>[] freqBucket = new ArrayList[highestFreq+1];

        for (int i = 0; i < freqBucket.length; i++) {
            freqBucket[i] = new ArrayList<Integer>();
        }

        for (int num : map.keySet()) {
            int freq = map.get(num);

            freqBucket[freq].add(num);
        }

        List<Integer> resp = new ArrayList<>();

        for (int i = freqBucket.length - 1; i > 0; i--) {
            if (freqBucket[i].size() > 0) {
                for (int num : freqBucket[i]) {
                    resp.add(num);

                    if (resp.size() >= k) {
                        int[] respArr = new int[k];
                        int counter = 0;
                        for (Integer number : resp) {
                            respArr[counter] = number;
                            counter++;
                        }
                        return respArr;
                    }
                }
            }
        }

        return new int[]{-1};
    }
}
