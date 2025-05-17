public class Solution {
    /**
     * @param nums1: List[int]
     * @param nums2: List[int]
     * @param k: an integer
     * @return: return List[List[int]]
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // write your code here
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> 
            Integer.compare(nums1[o1[0]] + nums2[o1[1]], nums1[o2[0]] + nums2[o2[1]]));
 
        for (int i = 0; i < nums2.length; i++) {
            minHeap.add(new int[]{0, i});
        }
        List<List<Integer>> allRes = new ArrayList<>();
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            int[] res = minHeap.poll();
            List<Integer> pair = new ArrayList<>() {{
                add(nums1[res[0]]);
                add(nums2[res[1]]);
            }};
            allRes.add(pair);
            if (res[0] + 1 < nums1.length) {
                minHeap.add(new int[]{res[0] + 1, res[1]});
            }
        }
        return allRes;
    }
}