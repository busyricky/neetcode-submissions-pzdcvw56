class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, max = 0;
        int mostFreq = 0;
        Map<Character,Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            map.put(c, 1 + map.getOrDefault(c, 0));

            mostFreq = Math.max(mostFreq, map.get(c));

            while ((r-l+1) - mostFreq > k) {
                char d = s.charAt(l);
                map.put(d, map.get(d) - 1);
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}
