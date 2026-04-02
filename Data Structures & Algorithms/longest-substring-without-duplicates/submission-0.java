class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) { return s.length(); }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put(chars[0],0);

        int maxLen = 0, l = 0;

        for (int r = 1; r < chars.length; r++) {
            if (map.containsKey(chars[r])) {
                l = Math.max(l, map.get(chars[r]) + 1);
            }

            map.put(chars[r], r);
            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}
