class Solution {
    public boolean isBipartite(int[][] g) {
        final int n = g.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(g, i, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] g, int index, int[] colors, int color) {
        if (colors[index] != 0) {
            return color == colors[index];
        }
        colors[index] = color;
        for (int i : g[index]) {
            if (!dfs(g, i, colors, -color)) {
                return false;
            }
        }
        return true;
    }
}