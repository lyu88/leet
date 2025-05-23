class Solution {
    public int largestIsland(int[][] grid) {
        int max = 0;
        List<Integer> areas = new ArrayList<>();
        areas.add(0); // trick for id is 0: area is 0
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] colors = new int[m][n];
        int id = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && colors[i][j] == 0) {
                    int area = dfs(i,j, id, grid, colors);
                    id++;
                    areas.add(area);
                    max = Math.max(area, max);
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int res = 1;
                    Set<Integer> ids = new HashSet<>();
                    for (int[] dir : dirs) {
                        int newi = i + dir[0];
                        int newj = j + dir[1];
                        if (newi < 0 || newi >= m || newj < 0 || newj >= n) {
                            continue;
                        }
                        ids.add(colors[newi][newj]);
                    }
                    for (int t : ids) {
                        res += areas.get(t);
                    }
                    max = Math.max(max, res);
                }
            }
        }
        return max;
    }

    int dfs( int i, int j, int id, int[][] grid, int[][] colors) {
        final int m = grid.length;
        final int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || colors[i][j] != 0 || grid[i][j]== 0) {
            return 0;
        }
        colors[i][j] = id;
        return 1 + dfs(i + 1, j,id, grid, colors)
            + dfs(i - 1, j,id, grid, colors)
            + dfs(i, j+1, id,grid, colors)
            + dfs(i, j-1, id,grid, colors);
    }
}