class Solution {
    public String reorganizeString(String S) {
        if (S.length() <= 1) return S;
        final int size = 26;
        final char offset = 'a';
        int[] freqMap = new int[size];
        for (int i = 0; i < S.length(); i++) {
        	freqMap[S.charAt(i) - offset]++;
        }
        PriorityQueue<Integer> indexMaxHeap = new PriorityQueue<Integer>( (o1, o2) -> Integer.compare(freqMap[o2], freqMap[o1]) == 0 ? Integer.compare(o2, o1) : Integer.compare(freqMap[o2], freqMap[o1]));
        for (int i = 0; i < size; i++) {
        	if (freqMap[i] > 0) indexMaxHeap.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!indexMaxHeap.isEmpty()) {
        	ArrayList<Integer> topIndexList = new ArrayList<>();
        	for (int i = 0; i < 2; i++) {
        		int index = indexMaxHeap.poll();
        		topIndexList.add(index);
        		sb.append((char)(index + offset));
        	}
        	for (int i = 0; i < topIndexList.size(); i++) {
                freqMap[topIndexList.get(i)]--;
                if (freqMap[topIndexList.get(i)] > 0) {
                    indexMaxHeap.add(topIndexList.get(i));
                }
            }
            if (indexMaxHeap.size() == 1 && freqMap[indexMaxHeap.peek()] > 1) {
            	return "";
            }
        }
        return sb.toString();
    }
}