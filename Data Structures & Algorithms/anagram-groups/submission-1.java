class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                count[c-'a']++;
            }

            String characterHash = Arrays.toString(count);
            
            if(map.containsKey(characterHash)) {
                map.get(characterHash).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(characterHash, list);
            }
        }

        List<List<String>> response = new ArrayList<>();
        
        for(List<String> list : map.values()) {
            response.add(list);
        }

        return response;
    }
}
