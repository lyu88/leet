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
                            deque.removeLast();
                        }
                    } else if (!item.equals(".")) {
                        deque.add(item);
                    }
                }
                start = index+1;
            }
            index++;
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder("/");
        while (!deque.isEmpty()) {
            sb.append(deque.remove()).append('/');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}