class Solution {

    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        Map<Character,Integer> freqMap = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);

            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));

            while (l < r && r-l+1 - maxFreq > k) {
                char d = s.charAt(l);
                freqMap.put(d, freqMap.get(d) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}
