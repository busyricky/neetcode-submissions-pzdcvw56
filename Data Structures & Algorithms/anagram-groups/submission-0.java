class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> bigMap = new HashMap<>();

        for (String s: strs) {
            Map<Character, Integer> tinyMap = createMap(s);
            List<String> list = new ArrayList<>();
            
            if (bigMap.containsKey(tinyMap)) {
                list = bigMap.get(tinyMap);
            }

            list.add(s);
            bigMap.put(tinyMap, list);
        }

        List<List<String>> response = new ArrayList<>();

        for (List<String> value : bigMap.values()) {
            response.add(value);
        }

        return response;
    }

    private Map<Character,Integer> createMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        return map;
    }
}
