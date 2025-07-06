class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        final int finalDay = days[days.length - 1];
        int[] dp = new int[finalDay + 1];
        boolean[] isTravel = new boolean[finalDay + 1];
        for (int day : days) {
            isTravel[day] = true;
        }
        for (int i = 1; i <= finalDay; i++) {
            dp[i] = isTravel[i] ? dp[i - 1] + costs[0] : dp[i - 1];
            int index = Math.max(0,i - 7);
            dp[i] = Math.min(dp[index] + costs[1], dp[i]);
            index = Math.max(0,i - 30);
            dp[i] = Math.min(dp[index] + costs[2], dp[i]);
        }
        return dp[finalDay];
    }
}