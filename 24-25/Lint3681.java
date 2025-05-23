
/**
 * 
 * 它这里讨巧了，实际上需要topological sort first
 * build graph
 * build indegrees
 * 从入度为0的nodes开始走图 
 * 
*/
public class Solution {
    /**
     * @param nodes: The number of nodes.
     * @param parents: The parents of the nodes.
     * @param values: The values of the nodes.
     * @return: The number of the remaining nodes in the tree.
     */
    public int deleteNodes(int nodes, int[] parents, int[] values) {
        // --- write your code here ---
        // bottom to up: sum up subtree
        for (int i = nodes - 1; i >= 1; i--) {
            int parent = parents[i];
            values[parent] += values[i];
        }
        if (values[0] == 0) {
            return 0;
        }
        // up to bottom: pass down if value = 0
        for (int i = 1; i < nodes; i++) {
            int parent = parents[i];
            if (values[parent] == 0) values[i] = 0;
        }
        int ret = 0;
        for (int val : values) {
            if (val != 0) {
                ret++;
            }
        }
        return ret;
    }
}