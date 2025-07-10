
// now the 2 passes work
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // global sum
        // find max
        // find min
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int max = Integer.MIN_VALUE, preSum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int num : nums) {
            preSum += num;
            int rangeMin = preSum - set.last();
            int rangeMax = preSum - set.first();
            max = Math.max(max, rangeMax);
            if (total > rangeMin) {
                max = Math.max(max, total - rangeMin);
            }
            set.add(preSum);
        }
        return max;
    }
}

// the requirement is non-empty subarray
// this one won't pass the case [-3,-2,-3]
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // global sum
        // find max
        // find min
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int max = Integer.MIN_VALUE, preSum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int num : nums) {
            preSum += num;
            int rangeMin = preSum - set.last();
            int rangeMax = preSum - set.first();
            max = Math.max(max, Math.max(rangeMax, total - rangeMin));
            set.add(preSum);
        }
        return max;
    }
}