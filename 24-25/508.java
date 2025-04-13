class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sum(root, map);
        int max = 0;
        for (var entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        List<Integer> list = new ArrayList<>();
        for (var entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int sum(TreeNode root, Map<Integer, Integer> map) {
        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            return root.val;
        }
        int sum = root.val;
        if (root.left != null) {
            sum += sum(root.left, map);
        }
        if (root.right != null) {
            sum += sum(root.right, map);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}