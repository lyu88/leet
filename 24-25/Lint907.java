public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: a string such that the same characters are at least distance k from each other
     */
    public String rearrangeString(String s, int k) {
        // Write your code here
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> cnt[o2 - 'a'] - cnt[o1 - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (cnt[c - 'a'] > 0) {
                maxHeap.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= k) {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                char c = maxHeap.poll();
                sb.append(c);
                list.add(c);
                cnt[c - 'a']--;
            }
            // add back
            for (char c : list) {
                if (cnt[c - 'a'] > 0) {
                    maxHeap.add(c);
                }
            }
        }
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            if (cnt[c - 'a'] > 1) {
                return "";
            }
            sb.append(c);
        }
        return sb.toString();
    }
}