class Solution {
    public int rob(int[] nums) {
        int[] step = new int[2];
        for (int num : nums) {
            int withoutNode = Math.max(step[0], step[1]);
            step[0] = step[1] + num; // with node
            step[1] = withoutNode;
        }
        return Math.max(step[0], step[1]);
    }
}