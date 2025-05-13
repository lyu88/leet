class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
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
                res += num * sign;
                i = index;
            } else if (c == '+') {
                sign = 1;
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                i++;
            } else {
                int preSign = stack.pop();
                int pre = stack.pop();
                res = pre + preSign * res;
                i++;
            }
        }
        return res;
    }
}