class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] sweep = new int[n];
        
        for(int[] q : queries) {
            sweep[q[0]]++;
            if(q[1] + 1 < n) {
                sweep[q[1] + 1]--;
            }
        }
        
        int applied = 0;
        for(int i = 0; i < n; i++) {
            applied += sweep[i];
            if(applied < nums[i]) {
                return false;
            }
        }
        return true;
    }
}