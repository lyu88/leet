class Solution {
    public int mctFromLeafValues(int[] arr) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for (int a : arr) {
            while (!stack.isEmpty() && stack.peek() <= a) {
                int key = stack.pop();
                if (stack.isEmpty()) {
                    ret += key * a;
                } else {
                    ret += key * Math.min(stack.peek(), a);
                }
            }
            stack.push(a);
        }
        while (stack.size() >= 2) {
            int key = stack.pop();
            ret += key * stack.peek();
        }
        return ret;
    }
}