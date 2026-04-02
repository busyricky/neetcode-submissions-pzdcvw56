class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, max = 0;
        char mostFreq = 'a';
        Map<Character,Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            map.put(c, 1 + map.getOrDefault(c, 0));

            mostFreq = mostFreq(map); // calculate mostFreq char in window

            while ((r-l+1) - map.getOrDefault(mostFreq,0) > k) {
                char d = s.charAt(l);
                map.put(d, map.getOrDefault(d,1)-1);
                mostFreq = mostFreq(map); // calculate mostFreq char in window
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }

    private char mostFreq(Map<Character,Integer> map) {
        int max = 0;
        char response = 'a';

        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                response = c;
            }
        }

        return response;
    }
}
