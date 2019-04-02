class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> maPreSumtoIndex = new HashMap<>();
        maPreSumtoIndex.put(0, -1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (!maPreSumtoIndex.containsKey(sum)) {
        		maPreSumtoIndex.put(sum, i);
        	}
        	int remain = sum - k; 
        	if (maPreSumtoIndex.containsKey(remain)) {
        		result = Math.max(result, i - maPreSumtoIndex.get(remain));
        	}
        }
        return result;
    }
}