public class Solution {
    /**
     * @param strings: a string array
     * @return: return a list of string array
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strings) {
            StringBuilder key = new StringBuilder("a");
            int delta = str.charAt(0) - 'a';
            for (int i = 1; i < str.length(); i++) {
                int charDistance = str.charAt(i) - delta < 'a' ? str.charAt(i) - delta + 26 : str.charAt(i) - delta;
                key.append((char)charDistance);
            }
            group.putIfAbsent(key.toString(), new ArrayList<>());
            group.get(key.toString()).add(str);
        }
        return new ArrayList<>(group.values());
    }
}