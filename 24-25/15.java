class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == -nums[i]) {
                    List<Integer> res = List.of(nums[i], nums[start], nums[end]);
                    ret.add(res);
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < -nums[i]) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<>(ret);
    }
}