class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        int start = 0;
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                StringBuilder sb = new StringBuilder("" + nums[start]);
                if (i - 1 > start) {
                    sb.append("->").append(nums[i-1]);
                }
                ret.add(sb.toString());
                start = i;
            }
        }
        return ret;
    }
}