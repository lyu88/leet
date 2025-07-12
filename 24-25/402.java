class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > c) {
                k--;
                deque.pollLast();
            }
            deque.add(c);
        }
        while (k > 0) {
            deque.pollLast();
            k--;
        }
        // 干掉最前的0
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }
        StringBuilder sb = new StringBuilder();
        deque.stream().forEach(c -> sb.append(c));
        return sb.length() == 0 ? "0" : sb.toString();
    }
}