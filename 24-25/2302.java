// runtime not good
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ret = 0L;
        int left = 0, right = 0;
        long sum = 0L;
        while (right < nums.length) {
            sum += nums[right];
            while (sum*(right - left + 1) >= k) {
                sum -= nums[left++];
            }
            ret += (right - left) + 1;
            right++;
        }
        return ret;
    }
}