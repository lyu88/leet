class Solution {
    public String decodeString(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return dfs(queue);
    }

    private String dfs(Queue<Character> queue) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = dfs(queue);
                for (int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}


class Solution {

    Map<Integer, Integer> closedPos = new HashMap<>();
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(i);
            } else if (c == ']') {
                closedPos.put(stack.pop(), i);
            }
        }
        return dfs(s, 0, s.length() - 1);
    }

    String dfs(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        int num = 0, i = start;
        while (i <= end) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10 + c - '0';
            } else if (c == '[') {
                int closed = closedPos.get(i);
                String t = dfs(s, i + 1, closed - 1);
                sb.append(t.repeat(num));
                num = 0;
                i = closed;
            } else {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
}