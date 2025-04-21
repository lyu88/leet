public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int move = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                move++;
            } else {
                nums[i - move] = nums[i];
            }
        }
        for (int i = 1; i <= move; i++) {
            nums[nums.length - i] = 0;
        }
    }
}