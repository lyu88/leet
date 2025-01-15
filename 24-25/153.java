class Solution {
    public int findMin(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        int mid = start + (end - start)/2;
        return Math.min(solve(nums, start, mid), solve(nums, mid + 1, end));
    }
}