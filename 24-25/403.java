class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Map<Integer, Boolean>> memo = new HashMap<>();
        for (int stone : stones) {
            memo.put(stone, new HashMap<>());
        }
        return dfs(stones[0], 0, memo, stones[stones.length - 1]);
    }

    private boolean dfs(int stone, int k, Map<Integer, Map<Integer, Boolean>> memo,
        final int target) {
        if (!memo.containsKey(stone)) {
            return false;
        }
        if (stone == target) {
            memo.get(stone).put(k, true);
            return true;
        }
        if (memo.get(stone).get(k) != null) {
            return memo.get(stone).get(k);
        }
        boolean flag = false;
        for (int t = k - 1; t <= k + 1; t++) {
            if (t > 0 && dfs(stone + t, t, memo, target) ) {
                flag = true;
                break;
            }
        }
        memo.get(stone).put(k, flag);
        return flag;
    }
}