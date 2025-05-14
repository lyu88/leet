class Solution {

    final int mod = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        for (int i =0; i< t; i++) {
            int ab = table[25];
            for (int j = 24; j >= 0; j--) {
                table[j + 1] = table[j];
            }
            table[0] = ab;
            table[1] = (table[1]+ab)%mod;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = (res + table[i]) % mod;
        }
        return res;
    }
}