// not bad
class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum)) {
                max = Math.max(max, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return max;
    }
}

// 稍加改动
// but TLE
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(-1);
        map.put(0, set);
        int max = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            for (var entry : map.entrySet()) {
                int key = entry.getKey();
                set = entry.getValue();
                if (set.contains(i - 2 * (preSum - key))) {
                    max = Math.max(max, 2 * (preSum - key));
                    break;
                }
            }
            map.putIfAbsent(preSum, new HashSet<>());
            map.get(preSum).add(i);
        }
        return max;
    }
}

// wrong answer
// didn't pass the case [0,0,1,0,0,0,1,1]
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int max = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            for (var entry : map.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if (2 * (preSum - key) == i - val) {
                    max = Math.max(max, i - val);
                    break;
                }
            }
            if (preSum != 0) {
                map.put(preSum, i);
            }
            
        }
        return max;
    }
}