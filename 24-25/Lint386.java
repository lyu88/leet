public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int start = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();
        int[] table = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
            table[c]++;
            while (set.size() > k) {
                char d = s.charAt(start++);
                table[d]--;
                if (table[d] == 0) set.remove(d);
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}