class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final int n = nums.length;
        int minLen = n + 1;
        int start = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLen = Math.min(minLen, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minLen == n + 1 ? 0 : minLen;
    }
}