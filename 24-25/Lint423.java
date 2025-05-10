public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */


     Map<Character, Character> map = new HashMap<>(){{
         put('(', ')');
         put('{', '}');
         put('[', ']');
     }};
    public boolean isValidParentheses(String s) {
        // write your code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}