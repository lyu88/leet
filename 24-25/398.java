class Solution {

    Map<Integer, List<Integer>> map;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<>(List.of(i)));
            }
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */