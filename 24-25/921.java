class Solution {
    public int minAddToMakeValid(String s) {
        int stack = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack++;
            } else {
                if (stack == 0) {
                    cnt++;
                } else {
                    stack--;
                }
            }
        }
        return cnt + stack;
    }
}