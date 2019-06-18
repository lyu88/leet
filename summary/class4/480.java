class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
        double[] ans = new double[n - k + 1];
        MedianDummper medianDummper = new MedianDummper(nums, k);
        for (int i = 0; i < n; i++) {
        	medianDummper.addNum(i);
        	if (i >= k) {
        		medianDummper.removeNum(i - k);
        	}
        	if (i >= k - 1) {
        		ans[i - k + 1] = medianDummper.findMedian();
        	}
        }
        return ans;
    }


    private class MedianDummper{
    	TreeSet<Integer> leftSet;
    	TreeSet<Integer> rightSet;
    	int[] nums;
    	int k;

    	public MedianDummper(int[] nums, int k) {
    		this.nums = nums;
    		this.k = k;
    		leftSet = new TreeSet<Integer>((o1, o2) -> Integer.compare(this.nums[o1], this.nums[o2]) == 0 ? Integer.compare(o1, o2) : Integer.compare(this.nums[o1], this.nums[o2]));
    		rightSet = new TreeSet<Integer>((o1, o2) -> Integer.compare(this.nums[o1], this.nums[o2]) == 0 ? Integer.compare(o1, o2) : Integer.compare(this.nums[o1], this.nums[o2]));
    	}

    	public void addNum(int index) {
    		if (leftSet.size() == rightSet.size()) {
    			leftSet.add(index);
    		} else {
				rightSet.add(index);
    		}
    		if (!leftSet.isEmpty() && !rightSet.isEmpty && leftSet.last() > rightSet.first()) {
				swap();
			}
    	}

    	private void swap() {
    		int tmpRight = rightSet.pollFirst();
    		int tmpLeft = leftSet.pollLast();
    		leftSet.add(tmpRight);
    		rightSet.add(tmpLeft);
    	}

    	public void removeNum(int index) {
    		leftSet.remove(index);
    		rightSet.remove(index);
    	}

    	public double findMedian() {
    		if (k % 2 == 0) {
    			return ((double)nums[leftSet.last()] + nums[rightSet.first()]) / 2;
    		} else {
    			return nums[leftSet.last()];
    		}
    	}
    }
}