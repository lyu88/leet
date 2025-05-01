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

// time exceeds limit
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> allRes = new HashMap<>();
        allRes.put(stones[0], new HashSet<>(Set.of(0)));
        for (int i = 1; i < stones.length; i++) {
            int key = stones[i];
            Set<Integer> res = new HashSet<>();
            for (int index = 0; index < i; index++) {
                int distance = stones[i] - stones[index];
                Set<Integer> set = outSteps(allRes.get(stones[index]));
                if (set.contains(distance)) {
                    res.add(distance);
                }
            }
            allRes.put(stones[i], res);
        }
        return !allRes.get(stones[stones.length - 1]).isEmpty();
    }

    private Set<Integer> outSteps(Set<Integer> inSet) {
        Set<Integer> out = new HashSet<>();
        for (int k : inSet) {
            if (k - 1 > 0) {
                out.add(k-1);
            }
            if (k > 0) {
                out.add(k);
            }
            out.add(k+1);
        }
        return out;
    }
}

//good now
class Solution {
    public boolean canCross(int[] stones) {
        final int len = stones.length;
        boolean[][] dp = new boolean[len][len];
        dp[0][1] = true;
        for (int i = 1; i < len; i++) {
            for (int index = 0; index < i; index++) {
                int diff = stones[i] - stones[index];
                if (diff >= len || !dp[index][diff]) {
                    continue;
                }
                if (i == len - 1) {
                    return true;
                }
                dp[i][diff + 1] = true;
                dp[i][diff] = true;
                if (diff - 1 > 0) {
                    dp[i][diff - 1] = true;
                }
            }
        }
        return false;
    }
}