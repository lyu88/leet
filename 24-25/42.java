class Solution {
    public int trap(int[] height) {
        final int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, height[i - 1]);
            leftMax[i] = max;
        }
        max = 0;
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, height[i + 1]);
            rightMax[i] = max;
        }
        int ret = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            ret += Math.max(0, min - height[i]);
        }
        return ret;
    }
}