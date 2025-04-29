// runtime too bad
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            set.remove(word);
            if (canBreak(word, set)) {
                ret.add(word);
            }
            set.add(word);
        }
        return ret;
    }

    boolean canBreak(String s, Set<String> set) {
        final int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int index = i + 1; index <= len; index++) {
                if (set.contains(s.substring(i, index)) && dp[index]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}

// trie solution even time exceeded limit
class Solution {

    private static final int SIZE = 26;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        Trie trie = new Trie();
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (trie.search(word, 0)) {
                ret.add(word);
            }
            trie.addWord(word);
        }
        return ret;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        public boolean search(String word, int index) {
            TrieNode node = root;
            if (index == word.length()) {
                return true;
            }
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                if (node.children[c - 'a'].isWord && search(word, i+1)) {
                        return true;
                } 
                node = node.children[c - 'a'];
            }
            return false;
        }
    }

    class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[SIZE];
    }
}