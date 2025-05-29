class Solution {
    public char findTheDifference(String s, String t) {
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[t.charAt(i) - 'a']++;
            table[s.charAt(i) - 'a']--;
        }
        table[t.charAt(t.length() - 1) - 'a']++;
        for (char c = 'a'; c <= 'z'; c++) {
            if (table[c - 'a'] == 1) {
                return c;
            }
        }
        return 0;
    }
}