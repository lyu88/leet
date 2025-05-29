class Solution {
    public String customSortString(String order, String s) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (table[c - 'a'] > 0) {
                sb.append(c); 
                table[c - 'a']--;
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (table[c - 'a'] > 0) {
                sb.append(c); 
                table[c - 'a']--;
            }
        }
        return sb.toString();
    }
}