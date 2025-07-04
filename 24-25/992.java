class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    int atMostK(int[] nums, int k) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        int start = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            mapFreq.put(nums[i], mapFreq.getOrDefault(nums[i], 0) + 1);
            while (mapFreq.size() > k) {
                mapFreq.put(nums[start], mapFreq.get(nums[start]) - 1);
                if (mapFreq.get(nums[start]) == 0) {
                    mapFreq.remove(nums[start]);
                }
                start++;
            }
            ret += i - start + 1; 
        }
        return ret;
    }
}