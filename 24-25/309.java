class Solution {
    public int maxProfit(int[] prices) {
        int preBuy = Integer.MIN_VALUE, preSell = 0, preRest = 0;
        for (int price : prices) {
            int buy = Math.max(preBuy, preRest - price);
            int sell = preBuy + price;
            int rest = Math.max(preSell, preRest);
            preBuy = buy;
            preSell = sell;
            preRest = rest;
        }
        return Math.max(preSell, preRest);
    }
}