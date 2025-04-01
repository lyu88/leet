class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(tails, num);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == tails.size()) {
                tails.add(num);
            } else {
                tails.set(index, num);
            }
        }
        return tails.size();
    }
}