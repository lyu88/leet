class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        mapFreq.put(0, 1);
        int preSum = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            cnt += mapFreq.getOrDefault(preSum - k, 0);
            mapFreq.put(preSum, mapFreq.getOrDefault(preSum, 0) + 1); 
        }
        return cnt;
    }
}