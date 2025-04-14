class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length -2), rob(nums, 1, nums.length -1));
    }

    public int rob(int[] nums, int start, int end) {
        int[] step = new int[2];
        for (int i = start; i <= end; i++) {
            int num = nums[i];
            int withoutNode = Math.max(step[0], step[1]);
            step[0] = step[1] + num; // with node
            step[1] = withoutNode;
        }
        return Math.max(step[0], step[1]);
    }
}