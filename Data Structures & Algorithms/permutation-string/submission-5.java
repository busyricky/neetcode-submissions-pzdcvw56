class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) { return false; }

        Map<Character,Integer> s1map = new HashMap<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1map.put(c, s1map.getOrDefault(c, 0) + 1);

            c = s2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (map.equals(s1map)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char c = s2.charAt(i-s1.length());
            char d = s2.charAt(i);

            map.put(c, map.get(c) - 1);
            map.put(d, map.getOrDefault(d, 0) + 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }

            if (map.equals(s1map)) {
                return true;
            }
        }

        return false;
    }
}
