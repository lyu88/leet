class Solution {
    public int totalFruit(int[] f) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        int i = 0, ret = 0;
        for (int j = 0; j < f.length; j++) {
            mapFreq.put(f[j], mapFreq.getOrDefault(f[j], 0) + 1);
            while (mapFreq.size() > 2) {
                mapFreq.put(f[i], mapFreq.get(f[i]) - 1);
                if (mapFreq.get(f[i]) == 0) {
                    mapFreq.remove(f[i]);
                }
                i++;
            }
            ret = Math.max(ret, j - i + 1);
        }
        return ret;
    }
}