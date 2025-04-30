class Solution {
    private final static int MOD = 1_000_000_007;

    public int numFactoredBinaryTrees(int[] arr) {
        final int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> mapIndex = new HashMap<>();
        long[] dp = new long[n];
        long ret = 0L;
        for (int i = 0; i < n; i++) {
            mapIndex.put(arr[i], i);
            dp[i] = 1L;
            int product = arr[i];
            for (int index = 0; index < i; index++) {
                int leftVal = arr[index];
                if (product%leftVal != 0 || !mapIndex.containsKey(product/leftVal)) {
                    continue;
                }
                int rightIndex = mapIndex.get(product/leftVal);
                dp[i] += dp[index] * dp[rightIndex];
                dp[i] %= MOD;
            }
            ret += dp[i];
            ret %= MOD;
        }
        return (int)ret;
    }
}