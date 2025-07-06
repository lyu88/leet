class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {  
            if (pre >= 0) {
                pre += num;
            } else {
                pre = num; // 以i为头思考，前文<0新开一个
            }
            max = Math.max(max, pre);
        }
        return max;
    }
}