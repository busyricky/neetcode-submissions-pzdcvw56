class PrefixTree {
    Map<Character, PrefixTree> tree;
    boolean isWord;

    public PrefixTree() {
         isWord = false;
         tree = new HashMap<>();
    }

    public void insert(String word) {
        PrefixTree curr = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!curr.tree.containsKey(c)) {
                curr.tree.put(c, new PrefixTree());
            }

            curr = curr.tree.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!curr.tree.containsKey(c)) {
                return false;
            }
            curr = curr.tree.get(c);
        }
        
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for (int i = 0; i <  prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (!curr.tree.containsKey(c)) {
                return false;
            }
            curr = curr.tree.get(c);
        }
        
        return true;
    }
}
