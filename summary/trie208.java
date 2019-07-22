class Trie {
    final int _size = 26;
    final int _offset = 'a';
    
    private class Node {
        public boolean isWord;
        public Node[] children;
        public Node() {
            children = new Node[_size];
        }
    } 
    
    public Node fakeRoot;
    /** Initialize your data structure here. */
    public Trie() {
        fakeRoot = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = fakeRoot;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - _offset] == null) {
                node.children[c - _offset] = new Node();
            }
            node = node.children[c - _offset];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = fakeRoot;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - _offset] == null) {
                return false;
            }
            node = node.children[c - _offset];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node node = fakeRoot;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - _offset] == null) {
                return false;
            }
            node = node.children[c - _offset];
        }
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */