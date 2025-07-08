class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ret = 0, sum = 0, cntZero = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > goal) {
                sum -= nums[start++];
                cntZero = 0;
            }
            if (sum == goal && start <= i) {
                while (start < i && nums[start] == 0) {
                    sum -= nums[start++];
                    cntZero++;
                }
                ret += cntZero + 1;
            }
        }
        return ret;
    }
}