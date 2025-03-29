class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            int k = (int) (Math.log(i + 1) / Math.log(2));
            if (isPowerOfTwoMinusOne(i)) {
                dp[i] = k;
            } else {
                int preStop = (int)Math.pow(2, k) - 1;
                int nextStop = (int)Math.pow(2, k + 1) - 1;
                dp[i] = k + 2 + dp[nextStop - i];
                for (int r = 1; r <= k; r++) {
                    int distance = (int)Math.pow(2, r - 1) - 1;
                    dp[i] = Math.min(dp[i], k + r + 1 + dp[i - preStop + distance]);
                }
            }
        }
        return dp[target];
    }

    private boolean isPowerOfTwoMinusOne (int n) {
        return (n & (n + 1)) == 0;
    }
}

class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        // (position, speed)
        queue.offer(new int[]{0, 1});
        visited.add("0,1");
        int step = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] state = queue.poll();
                int pos = state[0];
                int speed = state[1];
                if (pos == target) {
                    return step;
                }
                // forward
                int nextPos = pos + speed;
                int nextSpeed = 2 * speed;
                String nextState = "" + nextPos + "," + nextSpeed;
                if (!visited.contains(nextState) && nextPos < 2 * target) {
                    visited.add(nextState);
                    queue.add(new int[]{nextPos, nextSpeed});
                }
                // reverse
                nextPos = pos ;
                nextSpeed = speed > 0 ? -1 : 1;
                nextState = "" + nextPos + "," + nextSpeed;
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(new int[]{nextPos, nextSpeed});
                }
            }
             step++;
        }
        return -1;
    }
}