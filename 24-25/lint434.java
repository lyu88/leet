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