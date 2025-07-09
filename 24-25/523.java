// trick 这里
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (k != 0) preSum %= k;
            if(map.containsKey(preSum)){
                int index=map.get(preSum);
                if(i-index>=2){
                    return true;
                }
            }else{
               map.put(preSum,i); 
            }

        }
        return false;
    }
}

// TLE 果然有trick
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            for (var entry : map.entrySet()) {
                if ((preSum - entry.getKey())%k == 0 && i - entry.getValue() >= 2) {
                    return true;
                }
            }
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }
        }
        return false;
    }
}