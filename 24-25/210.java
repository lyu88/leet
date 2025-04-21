class Solution {
    public int[] findOrder(int n, int[][] preCourses) {
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
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!dfs(i, adj, new boolean[n], allRes, order)) {
                return new int[0];
            }
        }
        return order.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int index, Map<Integer, List<Integer>> adj, boolean[] visited,
        Boolean[] allRes, List<Integer> order) {
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
                if (!dfs(child, adj, visited, allRes, order)) {
                    allRes[index] = false;
                    return false;
                }
            }
        }
        visited[index] = false;
        allRes[index] = true;
        order.add(index);
        return true;
    }
}