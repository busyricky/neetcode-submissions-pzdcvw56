class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> resp = new ArrayList<>();
        int farthest = 0, currLen = 0;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            farthest = Math.max(farthest, map.get(c));
            currLen++;

            if (farthest == i) {
                resp.add(currLen);
                currLen = 0;
            }
        }

        return resp;
    }
}
