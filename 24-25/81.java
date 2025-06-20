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

// case analysis
// 迎刃而解 

class Solution {
    public boolean search(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    private boolean find(int[] a, int tgt, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (a[mid] == tgt) {
            return true;
        }
        if (a[mid] == a[start]) {
            return find(a, tgt, start + 1, mid - 1) || find(a, tgt, mid + 1, end);
        } else if (a[mid] < a[start]) {
            if (a[mid] < tgt) {
                return find(a, tgt, start, mid - 1) || find(a, tgt, mid + 1, end);
            }
            return find(a, tgt, start, mid - 1);
        } else {
            if (a[mid] < tgt) {
                return find(a, tgt, mid + 1, end);
            }
            return find(a, tgt, start, mid - 1) || find(a, tgt, mid + 1, end);
        }
    }
}

// special handling
class Solution {
    public boolean search(int[] nums, int tgt) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == tgt) {
                return true;
            }
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[mid] < nums[start]) {
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
        return false;
    }
}