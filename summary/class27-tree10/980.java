class Solution {
	final static int START = 1;
	final static int END = 2;
	final static int EMPTY = 0;
	final static int OBSTACLE = -1;
    public int uniquePathsIII(int[][] a) {
        final int n = a.length;
        final int m = a[0].length;
        int numStep = 0;
        int rowStart = -1;
        int colStart = -1;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (a[i][j] != OBSTACLE) {
        			numStep++;
        		}
        		if (a[i][j] == START) {
        			rowStart = i;
        			colStart = j;
        		}
        	}
        }

        boolean isVisited[][] = new boolean[n][m];
        return dfs(a, rowStart, colStart, numStep, isVisited);
    }

    private int dfs(int[][] a, int row, int col, int numStep, boolean[][] isVisited) {
    	if (row == -1 || row == a.length || col == -1 || col == a[0].length
    		|| isVisited[row][col]
    		|| a[row][col] == OBSTACLE) {
    		return 0;
    	}
    	isVisited[row][col] = true;
    	numStep--;
    	int ret = 0;
    	if (a[row][col] == END && numStep == 0) {
    		ret = 1;
    	} else {
    		ret = dfs(a, row + 1, col,numStep, isVisited)
    			+ dfs(a, row - 1, col,numStep, isVisited)
    			+ dfs(a, row, col + 1,numStep, isVisited)
    			+ dfs(a, row, col - 1,numStep, isVisited);
    	}
    	isVisited[row][col] = false;
    	return ret;
    }
}