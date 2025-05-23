class Solution {
    public int[] shortestToChar(String s, char c) {
        final int n = s.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
}