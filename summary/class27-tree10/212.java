class Solution {

	final static int _size = 26;
	final static int _offset = 'a';
    public List<String> findWords(char[][] a, String[] words) {
        List<String> results = new ArrayList<>();
        Trie trie = new Trie(words);
        final int n = a.length;
        final int m = a[0].length;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		dfs(a, i, j, trie._fakeRoot, new StringBuilder(), results, new boolean[n][m] isVisited);
        	}
        }
        return results;
    }

    private void dfs(char[][] a, int row, int col, TrieNode node, StringBuilder sb, List<String> results, boolean[][] isVisited) {
    	if (row == -1 || row == a.length || col == -1 || col == a[0].length
    		|| node._children[a[row][col] - _offset] == null
    		|| isVisited[row][col]) {
    		return;
    	}
    	sb.append(a[row][col]);
    	isVisited[row][col] = true;
    	node = node._children[a[row][col] - _offset];
    	if (node._isWord) {
    		results.add(sb.toString());
    	} 
    	dfs(a, row + 1, col, node, sb, results, isVisited);
    	dfs(a, row - 1, col, node, sb, results, isVisited);
    	dfs(a, row, col + 1, node, sb, results, isVisited);
    	dfs(a, row, col - 1, node, sb, results, isVisited);
    	sb.setLength(sb.length() - 1);
    	isVisited[row][col] = false;
    }

    private class Trie {
    	TrieNode _fakeRoot = new TrieNode();

    	public Trie(String[] words) {
    		for (String word : words) {
    			TrieNode cur = _fakeRoot;
    			for (int i = 0; i < word.length(); i++) {
    				char c = word.charAt(i);
    				if (cur._children[c - _offset] == null) {
    					cur._children[c - _offset] = new TrieNode();
    				}
    				cur = cur._children[c - _offset];
    			}
    			cur._isWord = true;
    		}
    	}
    	
    }

    private class TrieNode {
		boolean _isWord;
		TrieNode[] _children = new TrieNode[_size];
	}
}