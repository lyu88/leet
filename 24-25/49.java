class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String ref = toRef(str);
            map.putIfAbsent(ref, new ArrayList<>());
            map.get(ref).add(str);
        }
        return new ArrayList<>(map.values());
    }

    String toRef(String s) {
        int[] ref = new int[26];
        for (char c : s.toCharArray()) {
            ref[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (ref[i] > 0) {
                sb.append((char)('a' + i));
                sb.append(ref[i]);
            }
        }
        return sb.toString();
    }
}