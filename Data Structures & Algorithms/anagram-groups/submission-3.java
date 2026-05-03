class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            
            int[] charFreq = countChars(s);

            String freqString = Arrays.toString(charFreq);

            if (map.containsKey(freqString)) {
                map.get(freqString).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(freqString, newList);
            }
        }

        List<List<String>> resp = new ArrayList<>();

        for (String key : map.keySet()) {
            List<String> strList = map.get(key);
            resp.add(strList);
        }

        return resp;
    }

    private int[] countChars(String s) {
        int[] charFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreq[c - 'a']++;
        }

        return charFreq;
    }
}
