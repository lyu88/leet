class Solution {
    Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>() {{
        put("+", (a, b) -> a + b);
        put("-", (a, b) -> a - b);
        put("*", (a, b) -> a * b);
        put("/", (a, b) -> a / b);
     }};
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operators.containsKey(token)) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(operators.get(token).apply(first, second));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}