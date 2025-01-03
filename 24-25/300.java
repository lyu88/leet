//  O(n²) solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        final int len = nums.length;
        int[] dp = new int[len];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

// O(nlogn) binary search solution is eye-opening
class Solution {
    public int lengthOfLIS(int[] nums) {
        final int length = nums.length;
        int[] tails = new int[length];
        tails[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[len - 1]) {
                tails[len] = nums[i];
                len++;
            } else {
                int pos = findPos(tails, 0, len - 1, nums[i]);
                tails[pos] = nums[i];
            }
        }
        return len;
    }

    private int findPos(int[] nums, int left, int right, int val) {
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == val) {
                return mid;
            }
            if (nums[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}