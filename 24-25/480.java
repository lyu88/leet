class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
        double[] ret = new double[n - k + 1];
        TreeSet<Integer> left = new TreeSet<>((o1, o2) -> Integer.compare(nums[o1], nums[o2]) == 0
                ? Integer.compare(o1, o2)
                : Integer.compare(nums[o1], nums[o2]));
        TreeSet<Integer> right = new TreeSet<>((o1, o2) -> Integer.compare(nums[o1], nums[o2]) == 0
                ? Integer.compare(o1, o2)
                : Integer.compare(nums[o1], nums[o2]));

        for (int i = 0; i < n; i++) {
            // add index i
            right.add(i);
            left.add(right.removeFirst());
            // from i >= k to remove
            if (i >= k) {
                left.remove(i - k);
                right.remove(i - k);
            }
            // to balance
            while (left.size() > right.size()) {
                right.add(left.removeLast());
            }
            // from i = k - 1
            if (i >= k - 1) {
                double med = k%2 == 0 ? ((double)nums[left.last()] + nums[right.first()]) / 2
                    : nums[right.first()];
                ret[i - k + 1] = med;
            }
        }
        return ret;
    }
}