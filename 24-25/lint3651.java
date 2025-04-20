public class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++)
            graph.put(i, new ArrayList<>());
        for(int arr[]: edges) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        int count = 0;
        for (int index = 0; index < n; index++) {
            count += dfs(index, visited, graph);
        }
        return count;
    }

    private int dfs(int index, boolean[] visited, Map<Integer, List<Integer>> graph) {
        if (visited[index]) {
            return 0;
        }
        visited[index] = true;
        List<Integer> children = graph.getOrDefault(index, List.of());
        for (Integer child : children) {
            dfs(child, visited, graph);
        }
        return 1;
    }
}

// union find solution
public class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], ids);
        }
        Set<Integer> set = new HashSet<>();
        for (int id : ids) {
            set.add(find(id, ids));
        }
        return set.size();
    }   

    void union(int node1, int node2, int[] ids) {
        int father1 = find(node1, ids);
        int father2 = find(node2, ids);
        if (father1 < father2) {
            ids[father2] = father1;
        } else {
            ids[father1] = father2;
        }
    }

    int find(int node, int[] ids) {
        if (ids[node] == node) {
            return node;
        }
        return find(ids[node], ids);
    }
}