class Solution {
    public boolean canFinish(int n, int[][] preCourses) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] preCourse : preCourses) {
            int a = preCourse[0];
            int b = preCourse[1];
            if (adj.containsKey(a)) {
                adj.get(a).add(b);
            } else {
                adj.put(a, new ArrayList<>(List.of(b)));
            }
        }
        Boolean[] allRes = new Boolean[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(i, adj, new boolean[n], allRes)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int index, Map<Integer, List<Integer>> adj, boolean[] visited,
        Boolean[] allRes) {
        if (allRes[index] != null) {
            return allRes[index];
        }
        if (visited[index]) {
            allRes[index] = false;
            return false;
        }
        visited[index] = true;
        List<Integer> adjList = adj.get(index);
        if (adjList != null) {
            for (int child : adjList) {
                if (!dfs(child, adj, visited, allRes)) {
                    allRes[index] = false;
                    return false;
                }
            }
        }
        visited[index] = false;
        allRes[index] = true;
        return true;
    }

    
}

// bfs
class Solution {
    public boolean canFinish(int n, int[][] pres) {
        Map<Integer, List<Integer>> graph = buildGraph( pres);
        int[] indegrees = getIndegrees(n, graph);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                int key = queue.poll();
                if (visited[key]) {
                    return false;
                }
                visited[key] = true;
                if (!graph.containsKey(key)) {
                    continue;
                }
                for (int nei : graph.get(key)) {
                    indegrees[nei]--;
                    if (indegrees[nei] == 0) {
                        queue.add(nei);
                    }
                }
            }
        }
        for (int i =0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    int[] getIndegrees(int n, Map<Integer, List<Integer>> graph) {
        int[] indegrees = new int[n];
        for (int key : graph.keySet()) {
            for (int node : graph.get(key)) {
                indegrees[node]++;
            }
        }
        return indegrees;
    }

    Map<Integer, List<Integer>> buildGraph(int[][] pres) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : pres) {
            graph.computeIfAbsent(pre[1], k->new ArrayList<>()).add(pre[0]);
        }
        return graph;
    }
}