class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mapToNextGreater = new HashMap<>();
        Stack<Integer> monoStack = new Stack<>();
        for (int num : nums2) {
            while (!monoStack.isEmpty() && monoStack.peek() < num) {
                int key = monoStack.pop();
                mapToNextGreater.put(key, num);
            }
            monoStack.push(num);
        }
        final int n = nums1.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int key = nums1[i];
            ret[i] = mapToNextGreater.getOrDefault(key, -1);
        }
        return ret;
    }
}