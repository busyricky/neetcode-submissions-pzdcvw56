class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            if (!set.contains(s.charAt(r))) {
                int currLen = longestRepeatingSubstr(s, k, r);
                maxLen = Math.max(currLen, maxLen);
                set.add(s.charAt(r));
            }
        }

        return maxLen;
    }

    private int longestRepeatingSubstr(String s, int k, int i) {
        int counter = 0, l = i, currLen = 0;
        char c = s.charAt(l);
        List<Integer> list = new ArrayList<>();

        while (l > 0 && counter <= k) {
            counter++;
            l--;
        }

        counter = 0;
        int r = l;

        while (r < s.length()) {
            if (s.charAt(r) != c) {
                if (counter < k) {
                    counter++;
                    list.add(r);
                } else if (!list.isEmpty()){
                    l = list.get(0) + 1;
                    list.remove(0);
                    list.add(r);
                } else {
                    while (r < s.length() && s.charAt(r) != c) {
                        r++;
                        counter++;
                        
                    }
                    if (counter > k || r >= s.length()) {
                        l = r;
                        counter = 0;
                    }
                }
            } 

            currLen = Math.max(currLen, r-l+1);

            r++;
        }

        return currLen;
    }
}
