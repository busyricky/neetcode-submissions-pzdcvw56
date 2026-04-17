class Solution {
    public String minWindow(String s, String t) {
        int have = 0, minLen = Integer.MAX_VALUE, l = 0, start = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> curr = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (need.containsKey(c) && curr.getOrDefault(c,0) + 1 == need.get(c)) {
                have++;
            }

            curr.put(c, curr.getOrDefault(c,0) + 1);

            while (have == need.size()) { //valid window stuff
                if (minLen > r-l+1) {
                    start = l;
                    minLen = r-l+1;
                }
                char d = s.charAt(l);
                curr.put(d, curr.get(d)-1);
                if (need.containsKey(d) && curr.get(d) < need.get(d)) {
                    have--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}
