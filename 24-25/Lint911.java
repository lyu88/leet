public class Solution {
    /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> mapIndex = new HashMap<>();
        mapIndex.put(0, -1);
        int preSum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (mapIndex.containsKey(preSum - k)) {
                max = Math.max(max, i - mapIndex.get(preSum - k));
            }
            if (!mapIndex.containsKey(preSum)) {
                mapIndex.put(preSum, i);
            }
        }
        return max;
    }
}