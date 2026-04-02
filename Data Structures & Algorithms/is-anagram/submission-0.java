class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char d = t.charAt(j);

            if (map.isEmpty() || !map.containsKey(d)) {
                return false;
            } else if (map.get(d) == 1) {
                map.remove(d);
            } else {
                map.put(d, map.get(d) - 1);
            }
        }

        return map.isEmpty();
    }
}
