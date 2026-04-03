class WordDictionary {
    class Node {
        char c;
        Map<Character, Node> children;
        boolean isWord;

        Node(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node('0');
    }

    public void addWord(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                Node n = new Node(c);
                curr.children.put(c, n);
                curr = n;
            }
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                boolean resp = false;
            
                for (char d : curr.children.keySet()) {
                    resp = resp || helper(curr.children.get(d), word, i+1);
                }

                return resp;
            } else if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }

        return curr.isWord;
    }

    private boolean helper(Node curr, String word, int j) {

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                boolean resp = false;
            
                for (char d : curr.children.keySet()) {
                    resp = resp || helper(curr.children.get(d), word, i+1);
                }

                return resp;
            } else if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }

        return curr.isWord;
    }
}
