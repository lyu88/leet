class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[256];
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;
            if (map[c] == 2) {
                map[c] = 0;
                ret += 2;
            }
        }
        return ret < s.length() ? ret + 1 : ret;
    }
}