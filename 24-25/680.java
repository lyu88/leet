class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
    }

    boolean isPalindrome(String s, int l, int r) {
        while(l < r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
// too slow
class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return helper(s, start + 1, end) || helper(s, start, end - 1);
    }

    boolean helper(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        return s.charAt(start) == s.charAt(end) && helper(s, start+1, end-1);
    }
}