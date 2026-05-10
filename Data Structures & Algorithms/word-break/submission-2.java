class Solution {
    int[] processed;

    public boolean wordBreak(String s, List<String> wordDict) {
        processed = new int[s.length()];

        return helper(s, wordDict, 0);
    }

    private boolean helper(String s, List<String> wordDict, int idx) {
        if (idx == s.length()) {
            return true;
        } else if (idx > s.length() || processed[idx] == -1) {
            return false;
        }

        for (String t : wordDict) {
            if (matches(s,idx,t) && helper(s, wordDict, idx+t.length())) {
                return true;
            }
        }

        processed[idx] = -1;
        return false;
    }

    private boolean matches(String s, int idx, String t) {
        if (idx + t.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = s.charAt(idx + i);
            char d = t.charAt(i);

            if (c != d) {
                return false;
            }
        }

        return true;
    }
}
