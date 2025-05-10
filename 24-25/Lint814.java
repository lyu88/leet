/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param graph: a list of Undirected graph node
     * @param A: nodeA
     * @param B: nodeB
     * @return:  the length of the shortest path
     */
    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        // Write your code here
        Queue<UndirectedGraphNode> queA = new ArrayDeque<>();
        Set<UndirectedGraphNode> visitedA = new HashSet<>();
        queA.add(A);
        visitedA.add(A);
        Queue<UndirectedGraphNode> queB = new ArrayDeque<>();
        Set<UndirectedGraphNode> visitedB = new HashSet<>();
        queB.add(B);
        visitedB.add(B);
        
        int res = 0;
        while (!queA.isEmpty() && !queB.isEmpty()) {
            res++;
            final int sizeA = queA.size();
            for (int i = 0; i < sizeA; i++) {
                UndirectedGraphNode node = queA.poll();
                for (UndirectedGraphNode adj : node.neighbors) {
                    if (visitedB.contains(adj)) {
                        return res;
                    }
                    if (!visitedA.contains(adj)) {
                        visitedA.add(adj);
                        queA.add(adj);
                    }
                }
                
            }
            res++;
            final int sizeB = queB.size();
            for (int i = 0; i < sizeB; i++) {
                UndirectedGraphNode node = queB.poll();
                for (UndirectedGraphNode adj : node.neighbors) {
                    if (visitedA.contains(adj)) {
                        return res;
                    }
                    if (!visitedB.contains(adj)) {
                        visitedB.add(adj);
                        queB.add(adj);
                    }
                }
            }
        }
        return -1;
    }
}