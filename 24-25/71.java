class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        int index = 1, start = 1;
        while (index <= path.length()) {
            if (index == path.length() || path.charAt(index) == '/') {
                if (path.charAt(index-1) != '/') {
                    String item = path.substring(start, index);
                    if (item.equals("..")) {
                        if (!deque.isEmpty()) {
                            deque.pop();
                        }
                    } else if (!item.equals(".")) {
                        deque.push(item);
                    }
                }
                start = index + 1;
            } 
            index++;
        }
        StringBuilder sb = new StringBuilder("/");
        while (!deque.isEmpty()) {
            sb.append(deque.removeLast()).append('/');
        }
        if (sb.length() == 1) {
            return sb.toString();
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}