// segmentation tree
public class Solution {
    /**
     * @param nums1: An integer array
     * @param nums2: An integer array
     * @param queries: A two-dimensional array
     * @return: Result of maximum sum queries
     */
    class Node {
        int x, y, id, flag;
        public Node(int x, int y, int id, int flag) {
            this.x = x;
            this.y = y;
            this.id = id;
            this.flag = flag;
        }
    }

    class Tree {
        int l, r, m, v;
        Tree left, right;

        public Tree(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
            m = (l + r) >> 1;
        }

        private Tree getLeft() { return left == null ? (left = new Tree(l, m, v)) : left; }
        private Tree getRight() { return right == null ? (right = new Tree(m + 1, r, v)) : right; }

        public void update(int low, int high, int val) {
            if (high < l || low > r) return;
            if (l >= low && r <= high) {
                v = Math.max(v, val);
                return;
            }
            getLeft().update(low, high, val);
            getRight().update(low, high, val);
            v = Math.max(v, Math.max(left.v, right.v));
        }

        public int query(int low, int high) {
            if (high < l || low > r || v == -1) return -1;
            if (l >= low && r <= high) return v;
            return Math.max(getLeft().query(low, high), getRight().query(low, high));
        }
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        Node[] nodes = new Node[n + m];
        for (int i = 0; i < n; ++i) nodes[i] = new Node(nums1[i], nums2[i], i, 0);
        for (int i = 0; i < m; ++i) nodes[i + n] = new Node(queries[i][0], queries[i][1], i, 1);
        Arrays.sort(nodes, (a, b) -> a.x == b.x ? Integer.compare(a.flag, b.flag) : Integer.compare(b.x, a.x));
        int end = (int) 1e9;
        Tree root = new Tree(0, end, -1);
        int[] ans = new int[m];
        for (Node node : nodes) {
            if (node.flag == 0) root.update(node.y, node.y, node.x + node.y);
            else ans[node.id] = root.query(node.y, end);
        }
        return ans;
    }
}