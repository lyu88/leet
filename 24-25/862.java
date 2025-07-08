
// deque使用，可见功力
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Node> deque = new ArrayDeque<>();
        Node first = new Node(0L, -1);
        deque.add(first);
        final int n = nums.length;
        long preSum = 0;
        int min = n + 1;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            // 前文尾子太大，不如后进的preSum
            while (!deque.isEmpty() && deque.getLast().preSum() >= preSum) {
                deque.removeLast();
            }
            // 计算的核心，满足条件的头后文就不要了
            while (!deque.isEmpty() && deque.getFirst().preSum() <= preSum - k) {
                min = Math.min(min, i - deque.getFirst().index());
                deque.removeFirst();
            }
            deque.add(new Node(preSum, i));
        }
        return min == n + 1 ? -1 : min;
    }

    record Node(long preSum, int index) {
    }
}

// 稍微改动一下可以过，但巨慢
// 引入iterator 可以remove key during map traversal
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, -1);
        final int n = nums.length;
        long preSum = 0L;
        int min = n + 1;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            var iterator = map.entrySet().iterator();
            while(iterator.hasNext()) {
                var entry = iterator.next();
                long key = entry.getKey();
                if (preSum - key < k) {
                    break;
                }
                min = Math.min(min, i - entry.getValue());
                iterator.remove();
            }
            map.put(preSum, i);
        }
        return min == n + 1 ? -1 : min;
    }
}

// TLE 
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        final int n = nums.length;
        int preSum = 0, min = n + 1;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            for (var entry : map.entrySet()) {
                int key = entry.getKey();
                if (preSum - key < k) {
                    break;
                }
                min = Math.min(min, i - entry.getValue());
            }
            map.put(preSum, i);
        }
        return min == n + 1 ? -1 : min;
    }
}