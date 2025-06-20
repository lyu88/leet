class Solution {
    public int search(int[] nums, int a) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == a) {
                return mid;
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
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int tgt) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == tgt) {
                return mid;
            }
            if (nums[mid] < nums[start]) {
                if (nums[mid] < tgt && tgt <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] <= tgt && tgt < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}