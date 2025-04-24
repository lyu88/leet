int findMaxIndex(int[] nums) {
	int max = Integer.MIN_VALUE;
	int count = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] > max) {
			count = 1;
			max = nums[i];
		} else if (nums[i] == max) {
			count++;
		}
	}
	Random random = new Random();
	int pick = random.nextInt(count) + 1;
	int t = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] == max) {
			t++;
		} 
		if (t == pick) {
			return i;
		}
	}
	return -1;
}