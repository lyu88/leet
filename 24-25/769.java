class Solution {
    public int maxChunksToSorted(int[] arr) {
        int cnt = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - i;
            if (sum == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}