public class Solution {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        String max = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            String s1 = extendPal(s, i, i);
            if (s1.length() > max.length()) {
                max = s1;
            }
            s1 = extendPal(s, i-1, i);
            if (s1.length() > max.length()) {
                max = s1;
            }
        }
        return max;
    }

    private String extendPal(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}