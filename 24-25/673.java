class Solution {
    public int findNumberOfLIS(int[] nums) {
        final int len = nums.length;
        int[] length = new int[len];
        int[] count = new int[len];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        // Found longer subsequence
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        // Found another subsequence of same length
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, length[i]);
        }
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (length[i] == max) {
                ret += count[i];
            }
        }
        return ret;
    }
}