class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> monoStack = new Stack<>();
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!monoStack.isEmpty() && nums[monoStack.peek()] < num) {
                int index = monoStack.pop();
                ret[index] = num;
            }
            monoStack.push(i);
        }
        if (monoStack.isEmpty()) {
            return ret;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!monoStack.isEmpty() && nums[monoStack.peek()] < num) {
                int index = monoStack.pop();
                ret[index] = num;
            }
        }
        return ret;
    }
}