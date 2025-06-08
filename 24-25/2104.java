
// TLE 说明有重复计算，不是最优解：再想想
class Solution {
    public long subArrayRanges(int[] nums) {
        final int len = nums.length;
        long ret = 0L;
        for (int size = 2; size <= len; size++) {
            TreeSet<Integer> set = new TreeSet<>((o1, o2) -> nums[o1] == nums[o2] ? o1 - o2 : nums[o1] - nums[o2]);
            int i = 0;
            while (i < len) {
                set.add(i);
                if (i >= size) {
                    set.remove(i - size);
                }
                if (i >= size - 1) {
                    ret += nums[set.last()] - nums[set.first()];
                }
                i++;
            }
        }
        return ret;
    }
}

// O(n^2) working solution
class Solution {
        public long subArrayRanges(int[] A) {
        long res = 0;
        for (int i = 0; i < A.length; i++) {
            int max = A[i], min = A[i];
            for (int j = i; j < A.length; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                res += max - min;
            }
        }
        return res;
    }
}