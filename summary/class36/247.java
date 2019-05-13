class Solution {
    public List<String> findStrobogrammatic(int n) {
        char[][] a = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
        List<String> allResults = new ArrayList<>();
        if (n % 2 == 0) {
        	dfs(0, n, a, allResults, new ArrayDeque<>());
        } else {
			dfs(1, n, a, allResults, new ArrayDeque<>(Arrays.asList(new Character[] {'0'})));
			dfs(1, n, a, allResults, new ArrayDeque<>(Arrays.asList(new Character[] {'1'})));
			dfs(1, n, a, allResults, new ArrayDeque<>(Arrays.asList(new Character[] {'8'})));
        }
        return allResults;
    }

    private void dfs(int index, final int n, final char[][] a, List<String> allResults, Deque<Character> path) {
    	if (index == n) {
    		allResults.add(new String(path));
    		return;
    	}
    	for (int i = 0; i < a.length; i++) {
    		if (index == n - 2 && i == 0) {
    			continue;
    		}
    		path.addFirst(a[i][0]);
    		path.addLast(a[i][1]);
    		dfs(index + 2, n, a, allResults, path);
    		path.removeFirst();
    		path.removeLast();
    	}
    }
}