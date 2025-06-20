
// hmm .. divide and conquer
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


// binary search
class Solution {
    public int findMin(int[] a) {
        int start = 0, end = a.length - 1;
        while (start < end) {
            if (a[start] < a[end]) {
                return a[start];
            }
            int mid = start + (end - start)/2;
            if (a[mid] < a[start]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return a[start];
    }
}