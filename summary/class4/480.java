class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
        MedianDummper medianDummper = new MedianDummper(k);
        double[] ans = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
            medianDummper.add(nums[i]);
            if (i >= k) {
                medianDummper.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                ans[i - k + 1] = medianDummper.findMedian();
            }
        }
        return ans;
    }
    
    private class MedianDummper {
        int k;
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        
        public MedianDummper(int k) {
            this.k = k;
            maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            minHeap = new PriorityQueue<>();
        }
        
        public void add(int num) {
            if (maxHeap.size() == minHeap.size()) {
                if (!minHeap.isEmpty() && num >= minHeap.peek()) {
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                } else {
                    maxHeap.add(num);
                }
            } else {
                if (num <= maxHeap.peek()) {
                    maxHeap.add(num);
                    minHeap.add(maxHeap.poll());
                } else {
                    minHeap.add(num);
                }
            }
        }
        
        public void remove(int num) {
            if (num <= maxHeap.peek()) {
                maxHeap.remove(num);
            } else if (num >= minHeap.peek()) {
                minHeap.remove(num);
            }
            if (maxHeap.size() == minHeap.size() + 2) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }
        
        public double findMedian() {
            if (k % 2 == 0) {
                return ((double)maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                return maxHeap.peek();
            }
        }
    }
}