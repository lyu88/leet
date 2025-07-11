class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start]) {
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }
}

// 学习27的recursive写法
class Solution {
    public int removeDuplicates(int[] nums) {
        return helper(nums, nums.length - 1);
    }

    int helper(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }
        int len = helper(nums, index - 1);
        if (nums[index] != nums[len - 1]) {
            nums[len++] = nums[index];
        }
        return len;
    }
}