/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     List<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.putIfAbsent(node, 0);
            for (DirectedGraphNode nei : node.neighbors) {
                indegree.put(nei, indegree.getOrDefault(nei, 0) + 1);
            }
        }

        Queue<DirectedGraphNode> que = new ArrayDeque<>();
        for (DirectedGraphNode key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                que.add(key);
            }
        }

        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while (!que.isEmpty()) {
            DirectedGraphNode node = que.poll();
            res.add(node);
            for (DirectedGraphNode nei : node.neighbors) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    que.add(nei);
                }
            }
        }
        return res;
    }
}