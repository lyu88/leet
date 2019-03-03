class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
        	return false;
        }
        PriorityQueue<Integer> indexMinHeap = new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o1, o2));
        for (int handValue : hand) {
        	indexMinHeap.add(handValue);
        }
        while (!indexMinHeap.isEmpty()) {
        	if (indexMinHeap.size() < W) {
        		return false;
        	}
        	int minIndex = indexMinHeap.poll();
        	for (int i = 1; i < W; i++) {
        		int index = minIndex + i;
        		if (indexMinHeap.remove(index)) {
        			continue;
        		} else return false;
        	}
        	
        }
        return true;
    }
}