class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
        	return s;
        }
        final int size = 256;
        int[] charFreq = new int[size];
        for (int i = 0; i < s.length(); i++) {
        	charFreq[s.charAt(i)]++;
        }
        PriorityQueue<Integer> indexMaxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(charFreq[o2], charFreq[o1]) == 0 ? Integer.compare(o2, o1) : Integer.compare(charFreq[o2], charFreq[o1]));
        for (int i = 0; i < size; i++) {
        	if (charFreq[i] > 0) {
        		indexMaxHeap.add(i);
        	}
        }
        StringBuilder sb = new StringBuilder();
        while (!indexMaxHeap.isEmpty()) {
        	final int heapSize = indexMaxHeap.size();
        	if (heapSize < k) {
        		for (int i = 0; i < heapSize; i++) {
        			int index = indexMaxHeap.poll();
        			charFreq[index]--;
        			if (charFreq[index] > 0) {
        				return "";
        			}
        			sb.append((char)index );
        		} 
        	} else {
        		ArrayList<Integer> indexTopKList = new ArrayList<>();
        		for (int i = 0; i < k; i++) {
        			int index = indexMaxHeap.poll();
        			indexTopKList.add(index);
        			charFreq[index]--;
        			sb.append((char)index );
        		}
        		for (int i = 0; i < k; i++) {
        			int index = indexTopKList.get(i);
        			if (charFreq[index] > 0) {
        				indexMaxHeap.add(index);
        			}
        		}
        	}
        }
        return sb.toString();
    }
}