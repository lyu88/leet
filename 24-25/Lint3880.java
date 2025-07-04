public class Solution {
    /**
     * @param nums: An integer array
     * @param k: An integer
     * @param n: An integer
     * @return: Existence of good subarrays
     */
    public boolean checkSubarraySum(int[] nums, int k, int n) {
        // write your code here
        // prefix sum 
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // put in map with index
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey((sum - n) % k)) {
                if (i - map.get((sum - n) % k) > 1) {
                    return true;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return false;
    
    }
}