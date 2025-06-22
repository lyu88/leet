// a bit faster
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

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mapIndex = new HashMap<>();
        final int n = nums1.length;
        int[] ret = new int[n]; Arrays.fill(ret, -1);
        for (int i = 0; i < n; i++) {
            mapIndex.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int key = stack.pop();
                if (mapIndex.containsKey(nums2[key])) {
                    ret[mapIndex.get(nums2[key])] = nums2[i];
                }
            }
            stack.push(i);
        }
        return ret;
    }
}