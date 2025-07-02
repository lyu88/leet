class Solution {
    // 利用84，最好理解的方案
    // 每一层都是new ground
    public int maximalRectangle(char[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[j] = matrix[i][j] == '0' ? 0 : a[j]+1;
            }
            max = Math.max(max, largestRectangleArea(a));
        }
        return max;
    }

    int largestRectangleArea(int[] a) {
        final int n = a.length;
        int[] left = new int[n];   // left 最远能到达的index
        for (int i = 0; i < n; i++) {
            left[i] = i;
            while (left[i] - 1 >= 0 && a[left[i] - 1] >= a[i]) { // 可以到那边去
                left[i] = left[left[i] - 1];
            }
        }
        int[] right = new int[n]; // right 最远能到达的index
        for (int i = n - 1; i >= 0; i--) {
            right[i] = i;
            while (right[i] + 1 < n && a[right[i] + 1] >= a[i]) {
                right[i] = right[right[i] + 1];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] + 1;
            max = Math.max(max, len * a[i]);
        }
        return max;
    }
}