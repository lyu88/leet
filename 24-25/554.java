class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for (var bricks : wall) {
            int key = 0;
            for (int i = 0; i < bricks.size() -1; i++) {
                key += bricks.get(i);
                mapFreq.put(key, mapFreq.getOrDefault(key, 0) + 1);
            }
        }
        return wall.size() - mapFreq.values().stream().max(Integer::compareTo).orElse(0);
    }
}