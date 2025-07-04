class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ret = Double.MIN_VALUE;
        double sum = 0.;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
                ret = Math.max(ret, sum);
            }
            if (i == k - 1) {
                ret = sum;
            }
        }
        return ret/k;
    }
}