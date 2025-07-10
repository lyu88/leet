// recursive practice
class Solution {
    public int removeElement(int[] nums, int val) {
        return helper(nums, val, nums.length - 1);
    }

    int helper(int[] nums, int val, int index) {
        if (index == -1) {
            return 0; // base case as the length of 0 meaning none is qualified
        }
        int len = helper(nums, val, index - 1);
        if (nums[index] != val) {
            nums[len++] = nums[index]; 
        }
        return len;
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] != val) {
                start++;
            } else {
                swap(nums, start, end--);
            }
        }
        return start;
    }


    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}