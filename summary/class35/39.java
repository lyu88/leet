class Solution {
    public List<List<Integer>> combinationSum(int[] a, int tgt) {
    	Set<Integer> cans = new HashSet<>();
    	for (int i : a) {
    		cans.add(i);
    	}
        Set<Map<Integer, Integer>> allResults = new HashSet<>();
        Map<Integer, Integer> path = new HashMap<>();
        dfs(cans, tgt, allResults, path);
        List<List<Integer>> ret = new ArrayList<>();
        for (Map<Integer, Integer> map : allResults) {
        	List<Integer> path = new ArrayList<>();
        	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        		for (int i = 0; i < entry.getValue(); i++) {
        			path.add(entry.getKey());
        		}
        	}
        	ret.add(path);
        }
        return ret;
    }

    private void dfs(Set<Integer> cans, int tgt, Set<Map<Integer, Integer>> allResults, Map<Integer, Integer> path) {
    	if (tgt == 0 && path.size() > 0) {
    		allResults.add(new HashMap<Integer, Integer>(path));
    	} else {
    		for (Integer can : cans) {
    			if (tgt - can >= 0) {
    				path.put(can, path.getOrDefault(can, 0) + 1);
    				dfs(cans, tgt - can, allResults, path);
    				path.put(can, path.get(can) - 1);
    			}
    		}
    	}
    }
}



class Solution {
    public List<List<Integer>> combinationSum(int[] cans, int tgt) {
        Arrays.sort(cans);
        List<List<Integer>> allRes = new ArrayList<>();
        dfs(tgt, 0, cans, allRes, new ArrayList<Integer>());
        return allRes;
    }
    
    private void dfs(int tgt, int startIndex, int[] cans, List<List<Integer>> allRes, List<Integer> path) {
        if (tgt == 0) {
            allRes.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = startIndex; i < cans.length; i++) {
            int can = cans[i];
            if (can > tgt) {
                break;
            }
            path.add(can);
            dfs(tgt - can, i, cans, allRes, path);
            path.remove(path.size() - 1);
        }
    }
}