class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0, new int[s.length()]);
    }

    private boolean dfs(String s, List<String> wordDict, int idx, int[] works) {
        if (idx >= s.length()) {
            return true;
        }

        if (works[idx] == -1) {
            return false;
        }

        for (String word : wordDict) {
            if (check(s, word, idx)) {
                if (dfs(s, wordDict, idx + word.length(), works)) {
                    return true;
                }
            }
        }

        works[idx] = -1;
        return false;
    }

    private boolean check(String s, String word, int idx) {
        if (idx + word.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = s.charAt(idx + i);
            char d = word.charAt(i);

            if (c != d) {
                return false;
            }
        }

        return true;
    }
}
