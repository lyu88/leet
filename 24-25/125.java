class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;                
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            char c = Character.toLowerCase(s.charAt(start++));
            char d = Character.toLowerCase(s.charAt(end--));
            if (c != d) {
                return false;
            }
        }
        return true;
    }
}