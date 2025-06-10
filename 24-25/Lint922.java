public class Solution {
    /**
     * @param strings: a string array
     * @return: return a list of string array
     */
    public List<List<String>> groupStrings(String[] strings) {
        // write your code here
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = toKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        List<List<String>> ret = new ArrayList<>();
        for (String s : map.keySet()) {
            ret.add(map.get(s));
        }
        return ret;
    }

    String toKey(String s) {
        char c = s.charAt(0);
        int diff = c - 'a';
        StringBuilder sb = new StringBuilder("a");
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            sb.append(c - diff < 'a' ? c - diff + 26 : c - diff);
        }
        return sb.toString();
    }
}