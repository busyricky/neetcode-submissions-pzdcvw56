class WordDictionary {
    Map<Character, WordDictionary> map;
    boolean isWord;

    public WordDictionary() {
        map = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        WordDictionary curr = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!curr.map.containsKey(c)) {
                WordDictionary wd = new WordDictionary();
                curr.map.put(c, wd);
            }

            curr = curr.map.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        WordDictionary curr = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (c == '.') {  
                // if (i == word.length() - 1) return true;
                boolean resp = false;
                for (Character d : curr.map.keySet()) {
                    resp = resp || helper(word, i, curr.map.get(d));
                }
                return resp;
            } else if (!curr.map.containsKey(c)) {
                return false;
            } else {
                curr = curr.map.get(c);
            }
        }

        return curr.isWord;
    }

    private boolean helper(String s, int i, WordDictionary wd) {
        i++;

        if (i >= s.length()) { return wd.isWord; }

        char c = s.charAt(i);

        if (c == '.') {  
                // if (i == s.length() - 1) return true;
                boolean resp = false;
                for (Character d : wd.map.keySet()) {
                    resp = resp || helper(s, i, wd.map.get(d));
                }
                return resp;
        } else if (wd.map.containsKey(c)) {
            return helper(s, i, wd.map.get(c));
        } else {
            return false;
        }
    }

}
