public class Solution {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        int cur = 0;
        int sign = 1;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                int index = i + 1;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    index++;
                }
                num = Integer.valueOf(s.substring(i, index));
                i = index;
            } else if (c == '+') {
                cur += sign * num;
                sign = 1;
                num = 0;
                i++;
            } else if (c == '-') {
                cur += sign * num;
                sign = -1;
                num = 0;
                i++;
            } else if (c == '(') {
                stack.push(cur);
                stack.push(sign);
                cur = 0;
                sign = 1;
                i++;
            } else {
                cur += sign * num;
                int preSign = stack.pop();
                int pre = stack.pop();
                cur = pre + preSign * cur;
                num = 0;
                i++;
            }
        }
        cur += sign * num;
        return cur;
    }
}