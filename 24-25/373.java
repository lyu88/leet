class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(nums1[o1[0]] + nums2[o1[1]], 
            nums1[o2[0]] + nums2[o2[1]]));
        for (int i = 0; i < nums2.length; i++) {
            minHeap.add(new int[]{0, i});
        }
        while (ret.size() < k) {
            List<Integer> res = new ArrayList<>();
            int[] item = minHeap.poll();
            res.add(nums1[item[0]]);
            res.add(nums2[item[1]]);
            if (item[0] < nums1.length - 1) {
                minHeap.add(new int[]{item[0] + 1, item[1]});
            }
            ret.add(res);
        }
        return ret;
    }
}