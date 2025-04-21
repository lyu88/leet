class Solution {
    public void sortColors(int[] nums) {
        int start = 0, zero = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == 0) {
                swap(nums, zero, start);
                zero++;
                start++;
            } else if (nums[start] == 1) {
                start++;
            } else {
                swap(nums, start, end);
                end--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}