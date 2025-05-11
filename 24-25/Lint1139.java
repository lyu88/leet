public class Solution {
    /**
     * @param a: an array
     * @param k: the kth
     * @return: return the kth subarray
     */
     public long thekthSubarray(int[] a, long k) {
        int n = a.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i - 1];
        }

        long start = prefixSum[1], end = prefixSum[n];
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long count = countLessOrEqual(prefixSum, mid);
            if (count >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        long lessThanOrEqualStart = countLessOrEqual(prefixSum, start);
        if (lessThanOrEqualStart < k) {
            return end;
        }
        return start;
    }

    private long countLessOrEqual(long[] preSum, long tgt) {
        long count = 0;
        int n = preSum.length;
        int right = 1;
        for (int left = 0; left < n; left++) {
            while (right < n && preSum[right] - preSum[left] <= tgt) {
                count += (right - left);
                right++;
            }
            if (right == n) {
                break;
            }
        }
        return count;
    }


}