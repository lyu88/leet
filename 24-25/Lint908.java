public class Solution {
    /**
     * @param points: n points on a 2D plane
     * @return: if there is such a line parallel to y-axis that reflect the given points
     */
    public boolean isReflected(int[][] points) {
        if (points.length == 0) return true;
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        int left = 0, right = points.length - 1;
        int ref = points[left][0] + points[right][0];
        while (left < right) {
            if (points[left][0] + points[right][0] != ref) {
                return false;
            }
            if (points[left][1] != points[right][1]) {
                return false;
            }
            left++; right--;
        }
        if (left == right) {
            return ref == 2*points[left][0];
        }
        return true;
    }
}