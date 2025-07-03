class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > min) {
                ret += price - min;
            }
            min = price;
        }
        return ret;
    }
}