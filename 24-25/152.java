class Solution {
    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int preMin = 1, preMax = 1;
        // 跟求和非常类似，也是以i为头思考
        for (int num : nums) {
            int curMin = Math.min(num, Math.min(num * preMin, num * preMax));
            int curMax = Math.max(num, Math.max(num * preMin, num * preMax));
            ret = Math.max(ret, curMax);
            preMin = curMin;
            preMax = curMax;
        }
        return ret;
    }
}