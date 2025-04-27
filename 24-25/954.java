class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : arr) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        for (var entry : treeMap.entrySet()) {
            int key = entry.getKey();
            int cnt = entry.getValue();
            if (cnt == 0) {
                continue;
            }
            int tgtKey = key < 0 ? key / 2 : key * 2;
            if (key < 0 && key % 2 != 0 || !treeMap.containsKey(tgtKey) || cnt > treeMap.get(tgtKey)) {
                return false;
            }
            treeMap.put(tgtKey, treeMap.get(tgtKey)-cnt);
        }
        return true;
    }
}