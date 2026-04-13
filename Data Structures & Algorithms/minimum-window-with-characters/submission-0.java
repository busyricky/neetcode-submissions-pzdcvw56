class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int start = 0, l = 0, have = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            while (have == need.size()) {
                if (r-l+1 < minLen) {
                    start = l;
                    minLen = r-l+1;
                }

                char d = s.charAt(l);

                window.put(d, window.get(d) - 1);

                if (need.containsKey(d) && window.get(d).intValue() < need.get(d).intValue()) {
                    have--;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
