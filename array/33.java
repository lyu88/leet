class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1);
    }

    private int bs(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < nums[start]) {
            if (target > nums[mid]) {
                int index = bs(nums, target, mid + 1, end);
                if (index != -1) {
                    return index;
                }
            } 
            return bs(nums, target, start, mid - 1);
        } else {
            if (target < nums[mid]) {
                int index = bs(nums, target, start, mid - 1);
                if (index != -1) {
                    return index;
                }
            }
            return bs(nums, target, mid + 1, end);
        }
    }
}