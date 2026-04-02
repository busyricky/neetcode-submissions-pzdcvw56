class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> resp = new HashMap<>();
        Set<Map<Character,Integer>> set = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            Map<Character,Integer> freqMap = new HashMap<>();
            String s = strs[i];

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                freqMap.put(c, freqMap.getOrDefault(c,0) + 1);
            }

            if (set.contains(freqMap)) {
                List<String> currList = resp.get(freqMap);
                currList.add(s);
                resp.put(freqMap, currList);
            } else {
                List<String> currList = new ArrayList<String>();
                currList.add(s);
                resp.put(freqMap, currList);
                set.add(freqMap);
            }
        }

        List<List<String>> respList = new ArrayList<>();
        for (Map<Character,Integer> key : resp.keySet()) {
            respList.add(resp.get(key));
        }

        return respList;
    }
}
