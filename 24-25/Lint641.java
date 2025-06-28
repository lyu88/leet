public class Solution {
    /**
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> ret = new ArrayList<>();
        for (int num : nums) {
            if (num == lower + 1) {
                ret.add("" + lower);
            } else if (num > lower + 1) {
                ret.add(lower + "->" + String.valueOf(num - 1));
            }
            lower = num + 1;
            if (lower == Integer.MIN_VALUE) {
                return ret;
            }
        }
        if (lower == upper) {
            ret.add("" + lower);
        } else if (lower < upper) {
            ret.add(lower + "->" + String.valueOf(upper));
        }
        return ret;
    }
}

//讨巧了，不然也得用long
public class Solution {
    /**
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        for (int num : nums) {
            if (num > lower) {
                ret.add(getS(lower, num - 1));    
            }
            lower = num + 1;
            if (lower < num) {
                return ret;
            }
        }
        if (upper >= lower) {
            ret.add(getS(lower, upper));
        }
        return ret;
    }

    String getS (int start, int end) {
        if (start == end) {
            return ""+start;
        }
        return ""+start + "->" + end;
    }
}