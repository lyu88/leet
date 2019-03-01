class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a.length == 0) {
        	return new int[]{};
        }
        TreeMap<Integer, Integer> valueFreqBST = new TreeMap<>((o1, o2) -> Integer.compare(o1, o2));
        final int n = a.length;
        int[] results = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
        	// 1. add a[i]
        	if (!valueFreqBST.containsKey(a[i])) {
        		valueFreqBST.put(a[i], 1);
        	} else {
        		valueFreqBST.put(a[i], valueFreqBST.get(a[i]) + 1);
        	}

        	// 2. remove a[i - k]
        	if (i >= k) {
		    	if (valueFreqBST.get(a[i - k]) > 1) {
		    		valueFreqBST.put(a[i - k], valueFreqBST.get(a[i - k]) - 1);
		    	} else {
		    		valueFreqBST.remove(a[i - k]);
		    	}
			}
        	// 3. max in a[i - k + 1 -> i]
        	if (i - k + 1 >= 0) {
        		results[i - k + 1] = valueFreqBST.lastKey(); 
        	}
        }
        return results;
    }
}