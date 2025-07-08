class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, max = 0;
        boolean[] visited = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (visited[c]) {
                char d = s.charAt(start++);
                visited[d] = false;
            }
            visited[c] = true;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}