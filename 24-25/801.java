class Solution {
    public int minSwap(int[] a, int[] b) {
        final int len = a.length;
        int[] swap = new int[len];
        int[] not = new int[len];
        swap[0] = 1;
        for (int i = 1; i < len; i++) {
            not[i] = len;
            swap[i] = len;
            if (a[i - 1] < a[i] && b[i - 1] < b[i]) {
                not[i] = not[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (a[i - 1] < b[i] && b[i - 1] < a[i]) {
                swap[i] = Math.min(swap[i], not[i - 1] + 1);
                not[i] = Math.min(not[i], swap[i - 1]);
            }
        }
        return Math.min(not[len - 1], swap[len - 1]);
    }
}