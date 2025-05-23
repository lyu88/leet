// 大佬写法简洁，但不一定写得出
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) return true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int key : hand) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int it : map.keySet()) {
            if (map.get(it) > 0) {
                for (int i = groupSize - 1; i >= 0; i--) {
                    if (map.getOrDefault(it + i, 0) < map.get(it)) return false;
                    map.put(it + i, map.get(it + i) - map.get(it));
                }
            }
        }
        return true;
    }
}

// 我的话，还是会巧用remove
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) return true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int key : hand) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int it : map.keySet()) {
            if (map.get(it) > 0) {
                for (int i = groupSize - 1; i >= 0; i--) {
                    if (map.getOrDefault(it + i, 0) < map.get(it)) return false;
                    map.put(it + i, map.get(it + i) - map.get(it));
                }
            }
        }
        return true;
    }
}