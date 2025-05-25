class Solution {
    Set<Character> set = Set.of('+', '-', '/', '*');
    public int calculate(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10*num + c - '0';
            }
            if (set.contains(c) || i == s.length() - 1) {
                if (sign == '+' ) {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }
}