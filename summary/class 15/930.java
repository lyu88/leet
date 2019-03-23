class Solution {
    public int numSubarraysWithSum(int[] a, int tgt) {
        int start = 0;
        int sum = 0;
        int result = 0;
        for (int end = 0; end < a.length; end++) {
        	if (a[end] == 1) {
        		sum++;
        	}
        	while (sum == tgt) {

        	}
        }
    }
}