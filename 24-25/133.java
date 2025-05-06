/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        if (node == null) {
            return null;
        }
        queue.add(node);
        Node root = new Node(node.val);
        Map<Node, Node> mapNew = new HashMap<>();
        mapNew.put(node, root);
        while (!queue.isEmpty())  {
            Node cur = queue.poll();
            Node newCur = mapNew.get(cur);
            for (var neibor : cur.neighbors) {
                if (!mapNew.containsKey(neibor)) {
                    mapNew.put(neibor, new Node(neibor.val));
                    queue.add(neibor);
                } 
                newCur.neighbors.add(mapNew.get(neibor));
            }
        }
        return root;
    }
}