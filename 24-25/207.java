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