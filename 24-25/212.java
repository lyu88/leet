class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        final int m = board.length;
        final int n = board[0].length;
        TrieNode root = buildTrie(words);
        Set<String> allRes = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i,j , root, new boolean[m][n], new StringBuilder(), allRes);
            }
        }
        return new ArrayList<>(allRes);
    }

    void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited, StringBuilder sb, Set<String> allRes) {
        final int m = board.length;
        final int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || node.children[board[i][j] - 'a'] == null) {
            return;
        }
        char c = board[i][j];
        sb.append(c);
        visited[i][j] = true;
        node = node.children[c - 'a'];
        if (node.isWord) {
            allRes.add(sb.toString());
        }
        dfs(board, i + 1, j, node, visited, sb, allRes);
        dfs(board, i - 1, j, node, visited, sb, allRes);
        dfs(board, i , j + 1, node, visited, sb, allRes);
        dfs(board, i , j - 1, node, visited, sb, allRes);
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}