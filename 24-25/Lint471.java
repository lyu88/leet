public class Solution {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        Map<String, Integer> mapFreq = new HashMap<>();
        for (String s : words) {
            mapFreq.put(s, mapFreq.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(mapFreq.get(o1), mapFreq.get(o2))
         == 0 ? o2.compareTo(o1) : Integer.compare(mapFreq.get(o1), mapFreq.get(o2)));
        for (String s : mapFreq.keySet()) {
            minHeap.add(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        String[] res = new String[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}