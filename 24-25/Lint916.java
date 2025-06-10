public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            if (map[c] == 0) {
                 map[c]++;
            } else {
                map[c]--;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 256; i++) {
            cnt += map[i];
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }
}