class Solution {
    Map<Character,Integer> freqMap = new HashMap<>();
    char mostFrequent = '0';

    public int characterReplacement(String s, int k) {
        int l = 0, r = 1, maxLen = 1;
        
        mostFrequent = s.charAt(0);
        freqMap.put(s.charAt(0), 1);

        while (l <= r && r < s.length()) {
            updateFrequency(s, r);

            int currLen = r-l+1;

            if (k < currLen - freqMap.get(mostFrequent)) {
                while (l < r && k < currLen - freqMap.get(mostFrequent)) {
                    freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                    l++;
                    mostFrequent = mostFrequentChar();
                    currLen = r-l+1;
                }
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }

    private void updateFrequency(String s, int i) {
        char c = s.charAt(i);

        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        if (freqMap.get(mostFrequent) < freqMap.get(c)) {
            mostFrequent = c;
        }
    }

    private char mostFrequentChar() {
        char response = '0';
        int f = 0;

        for (char c : freqMap.keySet()) {
            if (f < freqMap.get(c)) {
                response = c;
                f = freqMap.get(c);
            }
        }

        return response;
    }
}
