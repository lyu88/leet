class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ret = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((o1, o2) -> o2[0]*o2[0] + o2[1]*o2[1]-o1[0]*o1[0] - o1[1]*o1[1]);
        for (int[] point : points) {
            if (maxHeap.size() < k) {
                maxHeap.add(new int[]{point[0], point[1]});
            } else {
                int[] max = maxHeap.peek();
                if (point[0]*point[0] + point[1]*point[1] < max[0]*max[0] + max[1]*max[1]) {
                    maxHeap.poll();
                    maxHeap.add(new int[]{point[0], point[1]});
                }
            }
        }
        for (int i = 0; i < k; i++) {
            int[] max = maxHeap.poll();
            ret[i][0] = max[0];
            ret[i][1] = max[1];
        }
        return ret;
    }
}