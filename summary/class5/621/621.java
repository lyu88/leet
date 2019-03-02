class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 0) {
            return tasks.length;
        }
        final int size = 26;
        int[] charFreq = new int[size];
        for (char c : tasks) {
            charFreq[c - 'A']++;
        }
        PriorityQueue<Integer> indexMaxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(charFreq[o2], charFreq[o1]) == 0 ? Integer.compare(o2, o1) : Integer.compare(charFreq[o2], charFreq[o1]));
        for (int i = 0; i < size; i++) {
            if (charFreq[i] > 0) {
                indexMaxHeap.add(i);
            }
        }
        int result = 0;
        while (!indexMaxHeap.isEmpty()) {
            final int heapSize = indexMaxHeap.size();
            ArrayList<Integer> topIndexList = new ArrayList<>();
            for (int i = 0; i < Math.min(n+1, heapSize); i++) {
                int index = indexMaxHeap.poll();
                topIndexList.add(index);
            }
            result += (n+1);
            for (int i = 0; i < topIndexList.size(); i++) {
                charFreq[topIndexList.get(i)]--;
                if (charFreq[topIndexList.get(i)] > 0) {
                    indexMaxHeap.add(topIndexList.get(i));
                }
            }
            if (indexMaxHeap.isEmpty() && n+1 > heapSize) {
                result -= (n + 1 - heapSize);
            }
        }
        return result;
    }
}