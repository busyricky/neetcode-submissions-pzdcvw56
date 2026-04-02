class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1count = new int[26], s2count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1count[i] == s2count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int j = s2.charAt(r) - 'a';
            s2count[j]++;
            if (s1count[j] == s2count[j]) {
                matches++;
            } else if (s1count[j] + 1 == s2count[j]) {
                matches--;
            }

            j = s2.charAt(l) - 'a';
            s2count[j]--;
            if (s1count[j] == s2count[j]) {
                matches++;
            } else if (s1count[j] - 1 == s2count[j]) {
                matches--;
            }

            l++;
        }

        return matches == 26;
    }
}
