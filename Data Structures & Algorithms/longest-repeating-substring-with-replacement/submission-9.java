class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int highestFreq = 0, maxLen = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            map.put(c, map.getOrDefault(c, 0) + 1);

            highestFreq = Math.max(highestFreq, map.get(c));

            while (r-l+1 - highestFreq > k) {
                char d = s.charAt(l);
                map.put(d, map.get(d) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}
