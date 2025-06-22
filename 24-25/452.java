class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int top = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[top][1] >= points[i][0]) {
                points[top][1] = Math.min(points[top][1], points[i][1]);
            } else {
                points[++top] = points[i];
            }
        }
        return top + 1;
    }
}