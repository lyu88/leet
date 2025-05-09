class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final int size = 256;
        int[] ref = new int[size];
        for (int i = 0; i < p.length(); i++) {
            ref[p.charAt(i)]++;
        }
        final int k = p.length();
        int diff = k;
        int[] map = new int[size];
        List<Integer> allRes = new ArrayList<>();
        for (int end = 0; end < s.length(); end++) {
            if (end >= k) {
                char d = s.charAt(end - k);
                map[d]--;
                if (map[d] < ref[d]) {
                    diff++;
                }
            }
            char c = s.charAt(end);
            map[c]++;
            if (map[c] <= ref[c]) {
                diff--;
            }
            if (diff == 0) {
                allRes.add(end - k + 1);
            }
        }
        return allRes;
    }
}