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

// just compare 2 arrays don't do something too complicated
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] tableS = new int[26];
        int[] tableP = new int[26];
        final int lenP = p.length();
        for (char c : p.toCharArray()) {
            tableP[c - 'a']++;
        };
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // first to remove
            if (i >= lenP) {
                char d = s.charAt(i - lenP);
                tableS[d - 'a']--;
            }
            // add item i
            char c = s.charAt(i);
            tableS[c - 'a']++;
            if (Arrays.equals(tableS, tableP)) ret.add(i - lenP + 1);
        }
        return ret;
    }
}

// static window size
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] tableS = new int[26];
        int[] tableP = new int[26];
        for (char c : p.toCharArray()) {
            tableP[c - 'a']++;
        }
        int start = 0, diff = p.length();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // first to remove
            if (i >= p.length()) {
                char d = s.charAt(start++);
                tableS[d - 'a']--;
                if (tableS[d - 'a'] < tableP[d - 'a']) {
                    diff++;
                }
            }
            // add item i
            char c = s.charAt(i);
            tableS[c - 'a']++;
            if (tableS[c - 'a'] <= tableP[c - 'a']) {
                diff--;
            }
            if (diff == 0) {
                ret.add(start);
            }
        }
        return ret;
    }
}