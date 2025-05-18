class Solution {
    public int minMoves(String[] matrix) {
        //prolly js bfs
        int m = matrix.length;
        int n = matrix[0].length();
        Map<Character, List<int[]>> portals = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String row = matrix[i];
            for (int j = 0; j < n; j++) {
                char c = row.charAt(j);
                if ('A' <= c && c <= 'Z') {
                    portals.computeIfAbsent(c, k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }
        
        final int INF = Integer.MAX_VALUE;
        int[][] dist = new int[m][n];
        for (int[] dr : dist) Arrays.fill(dr, INF);
        
        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new int[]{0, 0});
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];
            int d = dist[r][c];
            if (r == m - 1 && c == n - 1) {
                return d;
            }
            
            char cc = matrix[r].charAt(c);
            if ('A' <= cc && cc <= 'Z' && portals.containsKey(cc)) {
                for (int[] tgt : portals.get(cc)) {
                    int tr = tgt[0], tc = tgt[1];
                    if (dist[tr][tc] > d) {
                        dist[tr][tc] = d;
                        dq.addFirst(new int[]{tr, tc});
                    }
                }
                portals.remove(cc);
            }
            
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (matrix[nr].charAt(nc) == '#') continue;
                if (dist[nr][nc] > d + 1) {
                    dist[nr][nc] = d + 1;
                    dq.addLast(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }
}