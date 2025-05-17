public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int min = Integer.MAX_VALUE;
        int start = 0, sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}