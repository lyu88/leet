class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, ret = 0;
        int product = 1;
        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (start < i && product >= k) {
                product /= nums[start];
                start++;
            }
            if (product < k) {
                ret += i - start + 1; // 以i为结尾，此时window count how many subarrays
            }
        }
        return ret;
    }
}