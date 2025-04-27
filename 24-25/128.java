// runtime slow
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> mapToLen = new HashMap<>();
        for (int num : nums) {
            mapToLen.put(num, 1);
        }
        for (int num : nums) {
            if (!mapToLen.containsKey(num)) {
                continue;
            }
            int increment = num + 1;
            while (mapToLen.containsKey(increment)) {
                mapToLen.put(num, mapToLen.get(num) + mapToLen.get(increment));
                mapToLen.remove(increment);
                increment++;
            }
        }
        return Collections.max(mapToLen.values());
    }
}

// easiest understanding
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        int max = 1;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x + 1;
                while (set.contains(y)) {
                    y++;
                }
                max = Math.max(max, y - x);
            }
        }
        return max;
    }
}