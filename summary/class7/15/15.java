class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
        	return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
        	while (i > 0 && nums[i] == nums[i - 1]) {
        		i++;
        	}
        	if (i >= nums.length - 2) {
        		break;
        	}
        	int a = nums[i];
        	int j = i + 1;
        	int k = nums.length - 1;
        	while (j < k) {
        		while (j > i + 1 && nums[j] == nums[j-1]) {
        			j++;
        		}
        		while (k < nums.length - 1 && nums[k] == nums[k+1]) {
        			k--;
        		}
        		if (j >= k) {
        			break;
        		}
        		int b = nums[j];
        		int c = nums[k];
        		if (a + b + c == 0) {
        			List<Integer> result = new ArrayList<>(Arrays.asList(new Integer[]{a, b, c}));
        			results.add(result);
        			j++;
        			k--;
        		} else if (a + b + c < 0) {
        			j++;
        		} else {
        			k--;
        		}
        	}
        }
        return results;
    }
}