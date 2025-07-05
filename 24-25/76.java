class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int minIndex = -1;

        int[] tableP = new int[256];
        int diff = t.length();
        for (char c : t.toCharArray()) {
            tableP[c]++;
        }
        int start = 0;
        int[] tableS = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            tableS[c]++;
            if (tableS[c] <= tableP[c]) {
                diff--;
            }
            while (diff == 0) {
                if (i - start + 1 < minLen) {
                    minLen = i - start + 1;
                    minIndex = start;
                }
                char d = s.charAt(start++);
                tableS[d]--;
                if (tableS[d] < tableP[d]) {
                    diff++;
                }
            }
        }
        if (minIndex == -1) {
            return "";
        }
        return s.substring(minIndex, minIndex + minLen);
    }
}