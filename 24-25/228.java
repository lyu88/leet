// faster
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

// slowest
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end++;
            } else {
                ret.add(conv(start, end));
                start = nums[i];
                end = nums[i];
            }
        }
        ret.add(conv(start, end));
        return ret;
    }

    String conv(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return ""+start+"->"+end;
        }
    }
}

// hmmm 还是这个写法
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                continue;
            } else {
                ret.add(conv(nums, start, i - 1));
                start = i;
            }
        }
        if (start < nums.length) {
            ret.add(conv(nums, start, nums.length - 1));
        }
        return ret;
    }

    String conv(int[] nums, int start, int end) {
        if (start == end) {
            return String.valueOf(nums[start]);
        } else {
            return ""+ nums[start] + "->" + nums[end];
        }
    }
}