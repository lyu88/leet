class Solution {
	// ask question: if there is duplicate points
    public boolean isReflected(int[][] points) {
        if (points == null || points.length < 2)
        	return true;
        int leftMost = points[0][0];
        int rightMost = points[0][0];
        for (int i = 0; i < points.length; i++) {
        	leftMost = Math.min(leftMost, points[i][0]);
        	rightMost = Math.max(rightMost, points[i][0]);
        }
        int base2 = leftMost + rightMost;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
        	int y = points[i][1];
        	int x = points[i][0];
        	if (!map.containsKey(y)) {
        		Set<Integer> set = new HashSet<Integer>();
        		set.add(base2 - 2*x);
        		map.put(y, set);
        	} else {
        		set = map.get(y);
        		set.add(base2 - 2*x);
        		map.put(y, set);
        	}
        }
        for (Map.Entry<Integer, HashSet<Integer>> entry: map.entrySet()) {
        	Set<Integer> set = entry.getValue;
        	for (Integer i : set) {
        		if (!set.contains(-i)) return false;
        	}
        }
        return true;
    }    
}