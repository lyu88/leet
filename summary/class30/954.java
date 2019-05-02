class Solution {
    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> mapValToFreq = new TreeMap<>();
        for (int i : A) {
            mapValToFreq.put(i, mapValToFreq.getOrDefault(i, 0) + 1);
        }
        int i = 0;
        while (i < A.length / 2) {
            int key = mapValToFreq.firstKey();
            int freq = mapValToFreq.get(key);
            if (key < 0) {
                if (!mapValToFreq.containsKey(key / 2) || mapValToFreq.get(key / 2) < freq) {
                    return false;
                } else if (mapValToFreq.get(key / 2) == freq) {
                    mapValToFreq.remove(key / 2);
                } else {
                    mapValToFreq.put(key / 2, mapValToFreq.get(key / 2) - freq);
                }
                i += freq;
            } else if (key == 0) {
                if (freq % 2 != 0) {
                    return false;
                }
                i += freq / 2;
            } else {
                if (!mapValToFreq.containsKey(key * 2) || mapValToFreq.get(key * 2) < freq) {
                    return false;
                } else if (mapValToFreq.get(key * 2) == freq) {
                    mapValToFreq.remove(key * 2);
                } else {
                    mapValToFreq.put(key * 2, mapValToFreq.get(key * 2) - freq);
                }
                i += freq;
            }
            mapValToFreq.remove(key);
        }
        return mapValToFreq.isEmpty();
    }
}