class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for (int i : nums) {
            mapFreq.put(i, mapFreq.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        for (var entry : mapFreq.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (mapFreq.containsKey(key + 1)) {
                max = Math.max(max, val + mapFreq.get(key + 1));
            }
        }
        return max;
    }
}