class Solution {
    public boolean search(int[] nums, int a) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == a) {
                return true;
            }
             while (left < mid && nums[left] == nums[mid]) {
                left += 1;
             }
            while (right > mid && nums[right] == nums[mid]) {
                right -= 1;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= a && a < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < a && a <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}