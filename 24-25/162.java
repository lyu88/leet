// more concise
class Solution {
    public int findPeakElement(int[] a) {
        int start = 0, end = a.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] < a[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if ((mid == 0 || nums[mid-1]<nums[mid]) && (mid + 1 == nums.length || nums[mid]>nums[mid+1])) {
                return mid;
            }
            if (mid + 1 == nums.length || nums[mid]>nums[mid+1]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}