class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return solve(prices, 0, true, dp);
    }

    int solve(int[] prices, int currentDay, boolean canBuy, Integer[][] dp) {
        if (currentDay >= prices.length) return 0;

        int canBuyIndex = canBuy ? 1 : 0;

        if (dp[currentDay][canBuyIndex] != null) return dp[currentDay][canBuyIndex];

        if (canBuy) {
            int buyProfit = solve(prices, currentDay + 1, false, dp) - prices[currentDay];
            int dontBuyProfit = solve(prices, currentDay + 1, true, dp);
            dp[currentDay][canBuyIndex] = Math.max(buyProfit, dontBuyProfit);
            return Math.max(buyProfit, dontBuyProfit);
        }

        else {
            int sellProfit = prices[currentDay] + solve(prices, currentDay + 2, true, dp);
            int dontSellProfit = solve(prices, currentDay + 1, false, dp);
            dp[currentDay][canBuyIndex] = Math.max(sellProfit, dontSellProfit);
            return Math.max(sellProfit, dontSellProfit);
        }
    }
}
