class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int degree = 0, len = 0;
        for (int i = 0; i < nums.length; i++) {
            mapFreq.put(nums[i], mapFreq.getOrDefault(nums[i], 0) + 1);
            first.putIfAbsent(nums[i], i);
            if (mapFreq.get(nums[i]) > degree) {
                degree = mapFreq.get(nums[i]);
                len = i - first.get(nums[i]) + 1;
            } else if (mapFreq.get(nums[i]) == degree) {
                len = Math.min(len, i - first.get(nums[i]) + 1);
            }
        }
        return len;
    }
}