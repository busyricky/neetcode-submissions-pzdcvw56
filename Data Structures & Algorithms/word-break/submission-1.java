class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs (s, wordDict, 0, new int[s.length()]);
    }

    private boolean dfs(String s, List<String> wordDict, int idx, int[] works) {
        if (idx == s.length()) {
            return true;
        } else if (idx > s.length() || works[idx] == -1) {
            return false;
        }

        for (String word : wordDict) {
            if (matches(word, s, idx) && dfs(s, wordDict, idx + word.length(), works)) {
                return true;
            }
        }

        works[idx] = -1;
        return false;
    }

    private boolean matches(String word, String s, int idx) {
        int a = 0, b = idx;

        while (a < word.length() && b < s.length()) {
            char c = word.charAt(a);
            char d = s.charAt(b);
            if (c != d) {
                return false;
            }
            a++;
            b++;
        }

        return a != word.length() ? false : true;
    }
}
