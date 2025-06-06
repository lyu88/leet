class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> mono = new Stack<>();
        for (int num : arr) {
            if (mono.isEmpty() || mono.peek() <= num) {
                mono.push(num);
            } else {
                int max = mono.peek();
                while (!mono.isEmpty() && mono.peek() > num) {
                    mono.pop();
                }
                mono.push(max);
            }
        }
        return mono.size();
    }
}