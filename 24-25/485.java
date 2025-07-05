class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0, max = 0;
        for (int num : nums) {
            len = num == 1 ? len + 1 : 0;
            max = Math.max(max, len);
        }
        return max;
    }
}