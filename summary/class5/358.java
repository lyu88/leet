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
        PriorityQueue<Integer> indexMapHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(charFreq[o2], charFreq[o1]) == 0 ? Integer.compare(o1, o2) : Integer.compare(charFreq[o2], charFreq[o1]));
        for (int i = 0; i < size; i++) {
        	if (charFreq[i] > 0) {
        		indexMapHeap.add(i);
        	}
        }

        
    }
}