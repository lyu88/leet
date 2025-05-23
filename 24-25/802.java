class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        final int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outDegrees = new int[n];

        // Initialize reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Build reverse graph and count out-degrees
        for (int from = 0; from < n; from++) {
            for (int to : graph[from]) {
                reverseGraph.get(to).add(from);
                outDegrees[from]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outDegrees[i] == 0) {
                queue.add(i);
            }
        }
        boolean[] visited = new boolean[n];

        // bfs
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (int nei : reverseGraph.get(node)) {
                outDegrees[nei]--;
                if (outDegrees[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        // Collect safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                result.add(i);
            }
        }

        return result;
    }
}