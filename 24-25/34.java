class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x = findFirst(nums, target);
        int y = findLast(nums, target);
        return new int[]{x,y};
    }

    private int findLast(int[] nums, int a) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > a) {
                right = mid - 1;
            } else if (nums[mid] < a) {
                left = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != a) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }
}

// 嗯，也可以直接-1
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (Arrays.binarySearch(nums, target) < 0) {
            return new int[]{-1, -1};
        }
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    int findFirst(int[] nums, int tgt) {
        int res = 0;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == tgt) {
                res = mid;
                end = mid - 1;
            } else if (nums[mid] < tgt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    int findLast(int[] nums, int tgt) {
        int res = 0;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == tgt) {
                res = mid;
                start = mid + 1;
            } else if (nums[mid] < tgt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}