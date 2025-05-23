public class Solution {
	public int find(int[] fa, int x) {
        if(fa[x] == x) {
            return x;
        } else {
            return find(fa, fa[x]);
        }
    }

    private int identify(int x, int y, int m) {
    	return x * m + y;
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
    	int[] fa = new int[n*m];
    	boolean[] visited = new boolean[n*m];
    	for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
            	int pt = identify(i,j,m);
                fa[pt] = pt;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(operators == null) {
            return ans;
        }
        int[] zx = {0, 0, 1, -1};
        int[] zy = {1, -1, 0, 0};
        int cnt = 0;
        for(Point point : operators) {

            int x = point.x, y = point.y;
            int pt = identify(x,y,m);
            // 第i次操作的点 已经是岛屿了，跳过就好了
            if(visited[pt]) {
                ans.add(cnt);
                continue;
            }
            //第i次操作的点 出现了新的岛屿
            cnt++;
            //标记它是个岛屿
            visited[pt] = true;
            //遍历这个岛屿的四周四个方向
            for(int k = 0; k < 4; k++) {
                int nx = x + zx[k];
                int ny = y + zy[k];
                //判断往四周走有没有走越界，或者走到海洋里，越界或者走到海洋都是没有的状态
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || !visited[identify(nx, ny, m)]) {
                    continue;
                }
                //判断四周的岛屿是不是和当前第i次操作的岛屿 已经在一个集合了
                if(find(fa, pt) == find(fa, identify(nx, ny, m))) {
                    continue;
                }
                /*
                如果不是在一个集合里，那么i j所在的两个集合就是连通的，可以合并算为一个集合,然后让岛屿数量-1。
                我们只要让i所在集合的代表元改为j所在集合的代表元就完成了合并操作
                */
                else {
                    cnt--;
                    fa[find(fa, identify(nx, ny, m))] = find(fa, pt);
                }
            }
            
            ans.add(cnt);
        }
        return ans;
    }



}

// redo with method union
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */

    int find(int id, int[] g) {
        if (g[id] != id) {
            g[id] = find(g[id], g);
        }
        return g[id];
    }

    void union(int id1, int id2, int[] g) {
        int fa1 = find(id1, g);
        int fa2 = find(id2, g);
        if (fa1 < fa2) {
            g[fa2] = fa1;
        } else {
            g[fa1] = fa2;
        }
    }

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> ret = new ArrayList<>();
        if (operators.length == 0) {
            return ret;
        }
        int[] g = new int[n*m];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int site = x*m + y;
                g[site] = site;
            }
        }
        int cnt = 0;
        boolean[] visited = new boolean[n*m];
        for (Point operator : operators) {
            int x = operator.x;
            int y = operator.y;
            if (visited[x*m + y]) {
                ret.add(cnt);
                continue;
            }
            visited[x*m + y] = true;
            cnt++;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || !visited[nx*m + ny]) {
                    continue;
                }
                if (find(x*m+y, g) != find(nx*m + ny, g)) {
                    cnt--;
                    union(nx*m+ny, x*m+y, g);
                }
            }
            ret.add(cnt);
        }
        return ret;
    }
}
