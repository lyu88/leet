class Solution {
    public boolean exist(char[][] a, String word) {
        final int n = a.length;
        final int m = a[0].length;
        int rowStart = -1;
        int colStart = -1;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (a[i][j] == word.charAt(0)) {
        			rowStart = i;
        			colStart = j;
        		}
        	}
        }
        boolean[][] path = new boolean[n][m];
        return dfs(a, rowStart, colStart, word, path, 0);
    }

    private boolean dfs(int[][] a, int row, int col, final String word, boolean[][] path, int index) {
    	if (row == -1 || row == a.length || col == -1 || col == a[0].length
    		|| a[row][col] != word.charAt(index)
    		|| path[row][col]) {
    		return false;
    	}
    	path[row][col] = true;

    	boolean ret = false;
    	if (index == word.length() - 1 && a[row][col] == word.charAt(index)) {
    		ret = true;
    	} else {
    		ret = dfs(a, row - 1, col, word, path, index + 1) 
    			|| dfs(a, row + 1, col, word, path, index + 1)
    			|| dfs(a, row, col - 1, word, path, index + 1)
    			|| dfs(a, row, col + 1, word, path, index + 1);
    	}

    	path[row][col] = false;

    	return ret;
    }
}