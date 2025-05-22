class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> count[o2] - count[o1]);
        for (int i = 0; i < 26; i++) {
            if(count[i] > 0) maxHeap.add(i);
        }
        int ret = 0;
        while (maxHeap.size() > 0) {
            final int size = maxHeap.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < Math.min(size, n+1); i++) {
                int t = maxHeap.poll();
                list.add(t);
            }
            for (int t : list) {
                if (--count[t] > 0) maxHeap.add(t);
            }
            if (maxHeap.size() > 0) {
                ret += n+1;
            } else {
                ret += size;
            }
        }
        return ret;
    }
}