class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] map = ref(words2);
        return Arrays.stream(words1).filter(x -> inRef(x, map)).toList();
    }

    boolean inRef(String s, int[] ref) {
        int[] tab = new int[26];
        for (char c : s.toCharArray()) {
            tab[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (tab[i] < ref[i]) {
                return false;
            }
        }
        return true;
    }

    int[] ref(String[] word) {
        int[] ret = new int[26];
        for (String s : word) {
            int[] tab = new int[26];
            for (char c : s.toCharArray()) {
                tab[c - 'a']++;
                if (tab[c - 'a'] > ret[c - 'a']) {
                    ret[c - 'a'] = tab[c - 'a'];
                }
            }
        }
        return ret;
    }
}