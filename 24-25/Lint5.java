public class Solution {
    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        final int n = nums.length;
        return partition(nums, 0, n - 1, n - k);
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    int partition(int[] nums, int start, int end, int k) {
        int left = start, right = end;
        int pivot = nums[left];
        while (left <= right) {
                while (left <= right && nums[left] < pivot) {
                        left++;
                }
                while (left <= right && nums[right] > pivot) {
                        right--;
                }
                if (left <= right) {
                        swap(nums, left, right);
                        left++;
                        right--;
                }
        }
        if (k <= right) {
                return partition(nums, start, right, k);
        }
        if (k >= left) {
                return partition(nums, left, end, k);
        }
        return nums[k];
    }
}