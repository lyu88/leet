class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int[] minMax = findMinMax(nums);
        return Math.max(minMax[1] - minMax[0] - 2*k, 0);
    }

    int[] findMinMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return new int[]{min, max};
    }
}