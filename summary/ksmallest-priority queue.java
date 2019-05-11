private static int[] kSmallest(int[] array, int k) {
    if (k == 0) return new int[0];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
        @Override
        public int compare (Integer o1, Integer o2) {
            if (o1.equals(o2)) return 0;
            return o1 > o2 ? -1 : 1;
        }
    });
    for (int i = 0; i < array.length; i++) {
        if (i < k) {
            maxHeap.offer(array[i]);
            break;
        }
        if (array[i] < maxHeap.peek()) {
            maxHeap.poll();
            maxHeap.offer(array[i]);
        }
    }
    int[] ret = new int[k];
    for (int i = k -1; i >= 0; i--) {
        ret[i] = maxHeap.poll();
    }
    return ret;
}