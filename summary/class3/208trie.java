class Trie {
    
    private final int size = 26;
    private final int offset = 'a';
    private class Node {
        public boolean isWord;
        public Node[] childern;
        
        public Node() {
            childern = new Node[size];
        }
    }
    
    private Node fakeRoot;

    /** Initialize your data structure here. */
    public Trie() {
        fakeRoot = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = fakeRoot;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.childern[c - offset] == null) {
                node.childern[c - offset] = new Node();
            }
            node = node.childern[c - offset];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = fakeRoot;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.childern[c - offset] == null) {
                return false;
            }
            node = node.childern[c - offset];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = fakeRoot;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.childern[c - offset] == null) {
                return false;
            }
            node = node.childern[c - offset];
        }
        return node != null;
    }
}