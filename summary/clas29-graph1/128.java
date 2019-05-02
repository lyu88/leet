class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet(Arrays.asList(nums));
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int num : nums) {
        	if (resultMap.containsKey(num)) {
        		continue;
        	}
        	resultMap.put(num, 1);
        }
        for (int num : nums) {
        	if (resultMap.get(num) == 0) {
        		continue;
        	}
        	int result = resultMap.get(num);        
        	int increment = ++num;
        	while (resultMap.containsKey(increment)) {
        		result += resultMap.get(increment);
        		resultMap.put(increment, 0);
        		++increment;
        	}
        	resultMap.put(num, result);
        }
        int result = 1;
        for (MapEntry<Integer, Integer> entry : resultMap.entrySet()) {
        	result = Math.max(result, entry.Value);
        }
        return result;
    }
}