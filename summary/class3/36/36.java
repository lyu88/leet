class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int count = 9;
        final int iter = 3;
        for (int i = 0; i < count; i++) {
        	boolean[] countMap = new boolean[count];
        	for (int j = 0; j < count; j++) {
        		char c = board[i][j];
        		if (c == '.') {
        			continue;
        		}
        		if (!isValidDigit(c) || countMap[c-'1']) {
        			return false;
        		}
        		countMap[c-'1'] = true;
        	}
        }

        for (int j = 0; j < count; j++) {
        	boolean[] countMap = new boolean[count];
        	for (int i = 0; i < count; i++) {
        		char c = board[i][j];
        		if (c == '.') {
        			continue;
        		}
        		if (!isValidDigit(c) || countMap[c-'1']) {
        			return false;
        		}
        		countMap[c-'1'] = true;
        	}
        }

        for (int i = 0; i < count; i += 3) {
        	int a = i;
        	for (int j = 0; j < count; j += 3) {
        		int b = j;
        		boolean[] countMap = new boolean[count];
        		for (int k = 0; k < iter; k++) {
        			for (int l = 0; l < iter; l++) {
        				char c = board[a+k][b+l];
			     		if (c == '.') {
			    			continue;
			    		}
			    		if (!isValidDigit(c) || countMap[c-'1']) {
			    			return false;
			    		}
			    		countMap[c-'1'] = true;       				
        			}
        		}
        	}
        }
        return true;
    }

    private boolean isValidDigit(char c) {
    	if (c < '1' || c > '9') {
    		return false;
    	}
    	return true;
    }
}