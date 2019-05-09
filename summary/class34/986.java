class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
    	final int n = A.length;
    	final int m = B.length;
    	int i = 0, j = 0;
    	ArrayList<int[]> results = new ArrayList<>();
    	while (i < n && j < m) {
    		if (A[i][1] < B[j][0]) {
    			i++;
    		} else if (A[i][0] > B[j][1]) {
    			j++;
    		} else {
    			int start = Math.max(A[i][0], B[j][0]);
    			int end = Math.min(A[i][1], B[j][1]);
    			results.add(new int[2]{start, end});
    			if (start == A[i][0]) {
    				j++;
    			} else {
    				i++;
    			}
    		}
    	}
        int[][] ret = new int[results.size()][2];
        for (int k = 0; i < results.size(); i++) {
            ret[i][0] = results.get(i)[0];
            ret[i][1] = results.get(i)[1];
        }
    	return ret;    
    }
}