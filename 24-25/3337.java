// TLE
class Solution {
    final static int mod = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] pre = new int[26];
        for (int i = 0; i < s.length(); i++) {
            pre[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < 26; j++) {
                int moves = nums.get(j);
                for (int k = 1; k <= moves; k++) {
                    cur[(j + k)%26] = (pre[j] + cur[(j + k)%26]) % mod;
                }
            }
            pre = cur;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = (res + pre[i]) % mod;
        }
        return res;
    }
}

// math inside
class Solution {
    final static int mod = 1_000_000_007;
    long[][] transform = new long[26][26];
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] freq = new long[1][26];
        for (int i = 0; i < s.length(); i++) {
            freq[0][s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                transform[i][(i + j)%26] = 1;
            }
        }
        transform = powerMatrix(transform, t);
        freq = multiplyMatrices(freq, transform);
        long total = 0;
        for (long cnt : freq[0]) {
            total = (total + cnt) % mod;
        }
        return (int)total; 
    }

    long[][] powerMatrix(long[][] matrix, long exponent) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) result = multiplyMatrices(result, matrix);
            matrix = multiplyMatrices(matrix, matrix);
            exponent >>= 1;
        }
        return result;
    }

    long[][] multiplyMatrices(long[][] A, long[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        long[][] result = new long[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                long sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum = (sum + (A[i][k] * B[k][j]) % mod) % mod;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}