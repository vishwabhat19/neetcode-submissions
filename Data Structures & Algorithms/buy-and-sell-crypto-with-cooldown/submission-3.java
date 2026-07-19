class Solution {
    public int maxProfit(int[] prices) {
        int currentDay = 0;
        int n = prices.length;
        boolean canBuy = true;
        Integer[][] dp = new Integer[prices.length][2];
        return solve(prices, currentDay, n, canBuy, dp);
    }

    int solve(int[] prices, int currentDay, int n, boolean canBuy, Integer[][] dp) {
        if (currentDay >= n) return 0;

        int canBuyIndex = canBuy ? 1 : 0;
        if (dp[currentDay][canBuyIndex] != null) return dp[currentDay][canBuyIndex];
        if (canBuy) {
            int buyProfit = solve(prices, currentDay + 1, n, false, dp) - prices[currentDay];
            int dontBuyProfit = solve(prices, currentDay + 1, n, true, dp);
            dp[currentDay][canBuyIndex] = Math.max(buyProfit, dontBuyProfit);
            return dp[currentDay][canBuyIndex];
        }
        else{
            int sellProfit = prices[currentDay] + solve(prices, currentDay + 2, n, true, dp);
            int dontSellProfit = solve(prices, currentDay + 1, n, false, dp);
            dp[currentDay][canBuyIndex] = Math.max(sellProfit, dontSellProfit);
            return dp[currentDay][canBuyIndex];
        }
    }
}
