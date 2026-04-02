class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        Map<Character, Integer> currMap = new HashMap<>();

        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            currMap.put(c, currMap.getOrDefault(c,0) + 1);

            if (map.containsKey(c) && map.get(c) >= currMap.getOrDefault(c,0)) {
                // do nothing
            } else {
                while (l <= r) {
                    char d = s2.charAt(l);
                    currMap.put(d, currMap.getOrDefault(d,0) - 1);
                    l++;

                    if (currMap.getOrDefault(c,0) == 0 || (map.containsKey(c) && currMap.getOrDefault(c,0) <= map.get(c))) {
                        break;
                    }
                }
            }

            if (r - l + 1 >= s1.length()) {
                return true;
            }
        }

        return false;
    }
}
