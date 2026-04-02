class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> endMap = new HashMap<>();
        Map<Integer,Integer> startMap = new HashMap<>();

        int maxLen = 0;

        for (int num : nums) {
            //just skip if we already processed this number
            if(endMap.containsKey(num)) {
                continue;
            }

            if (!endMap.containsKey(num) && !startMap.containsKey(num)) {
                endMap.put(num, 1);
                startMap.put(num, 1);
            }

            //add num to end of current consecutive sequence ending with num
            if (endMap.containsKey(num-1)) {
                endMap.put(num, endMap.get(num-1) + 1);
            }

            //add num to beginning of current consecutive sequence starting with num
            if (startMap.containsKey(num+1)) {
                startMap.put(num, startMap.get(num+1) + 1);
            }

            //update current sequence
            int startOfCurrSeq = num - endMap.get(num) + 1;
            int endOfCurrSeq = num + startMap.get(num) - 1;
            int lengthOfCurrSeq = endOfCurrSeq - startOfCurrSeq + 1;

            endMap.put(endOfCurrSeq, lengthOfCurrSeq);
            startMap.put(startOfCurrSeq, lengthOfCurrSeq);

            maxLen = Math.max(maxLen, lengthOfCurrSeq);
        }

        return maxLen;
    }
}
