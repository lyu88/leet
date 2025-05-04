class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for (int[] d : dominoes) {
            int key = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            mapFreq.put(key, mapFreq.getOrDefault(key, 0) + 1);
        }
        int sum = 0;
        return mapFreq.values().stream().map(this::calc).mapToInt(x -> x).sum();
    }

    int calc(int n) {
        return n * (n - 1)/2;
    }
}