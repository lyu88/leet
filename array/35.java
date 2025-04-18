class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index < 0 ? - (index + 1) : index;
    }
}

// raw
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}

// recursive
class Solution {
    public int searchInsert(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    private int find(int[] nums, int target, int start, int end) {
        if (target <= nums[start]) {
            return start;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return find(nums, target, mid + 1, end);
        }
        return find(nums, target, start, mid);
    }
}