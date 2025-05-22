class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (o1, o2) -> count[o2 - 'a'] - count[o1 - 'a']
        );

        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > (s.length() + 1) / 2) {
                return ""; // Not possible
            }
            if (count[c - 'a'] > 0) {
                maxHeap.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            char ch1 = maxHeap.poll();
            char ch2 = maxHeap.poll();
            sb.append(ch1).append(ch2);
            if (--count[ch1 - 'a'] > 0) {
                maxHeap.add(ch1);
            }
            if (--count[ch2 - 'a'] > 0) {
                maxHeap.add(ch2);
            }
        }
        if (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }
        return sb.toString();
    }
}