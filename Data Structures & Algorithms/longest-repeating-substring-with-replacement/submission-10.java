class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int mostFreq = 0, maxLen = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            map.put(c, map.getOrDefault(c,0) + 1);

            mostFreq = Math.max(mostFreq, map.get(c));

            while ((r-l+1) - mostFreq > k) {
                char d = s.charAt(l);
                l++;
                if (map.get(d) - 1 <= 0) {
                    map.remove(d);
                } else {
                    map.put(d, map.get(d) - 1);
                }
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}
