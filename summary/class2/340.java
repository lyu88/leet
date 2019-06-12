class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> mapCharToFreq = new HashMap<>();
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mapCharToFreq.put(c, mapCharToFreq.getOrDefault(c, 0) + 1);
            
            while (mapCharToFreq.size() > k) {
                char ou = s.charAt(start);
                if (mapCharToFreq.get(ou) == 1) {
                    mapCharToFreq.remove(ou);
                } else {
                    mapCharToFreq.put(ou, mapCharToFreq.get(ou) - 1);
                }
                start++;
            }
            len = Math.max(len, i - start + 1);
        }
        return len;
    }
}