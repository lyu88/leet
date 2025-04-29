class Solution {
    public long countSubarrays(int[] nums, int k) {
        final int max = findMax(nums);
        int cnt = 0, left = 0, right = 0;
        long ret = 0L;
        while (right < nums.length) {
            if (nums[right] == max) {
                cnt++;
            }
            while (cnt >= k) {
                ret += nums.length - right;
                if (nums[left] == max) {
                    cnt--;
                }
                left++;
            }
            right++;
        }
        return ret;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }
}