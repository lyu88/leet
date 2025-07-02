class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] left = new int[n]; left[0] = 1;
        int[] right = new int[n]; right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] ret = new int[n]; 
        ret[n - 1] = left[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
            ret[i] = left[i] * right[i];
        }
        return ret;
    }
}

// extra O(1) space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] output = new int[n];

        // Step 1: output[i] = product of all elements to the left of i
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: R = product of all elements to the right of i
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * R;
            R *= nums[i];
        }

        return output;
    }
}