class Solution {
    public int[][] merge(int[][] intervals) {
        int top = 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[top][1] >= intervals[i][0]) {
                intervals[top][1] = Math.max(intervals[top][1], intervals[i][1]);
            } else {
                intervals[++top] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals, 0, top + 1);
    }
}