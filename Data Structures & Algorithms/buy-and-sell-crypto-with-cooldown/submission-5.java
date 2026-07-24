class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length+1][2];
        return solve(prices, 0, true, dp);
    }

    int solve(int[] prices, int currentDay, boolean canBuy, Integer[][] dp ) {
        if (currentDay >= prices.length) {
            return 0;
        }
        
        int buyIndex = canBuy ? 1 : 0;

        if (dp[currentDay][buyIndex] != null) return dp[currentDay][buyIndex];

        if (canBuy) { //I have no stock to sell
            int buyTodayProfit = solve(prices, currentDay + 1, false, dp) - prices[currentDay];
            int dontBuyTodayProfit = solve(prices, currentDay+1, true, dp);
            int max = Math.max(buyTodayProfit, dontBuyTodayProfit);
            dp[currentDay][buyIndex] = max;
            return max;
        }
        else {
            //I have stock to sell. I can sell or not sell
            int sellTodayProfit = solve(prices, currentDay+2, true, dp) + prices[currentDay];
            int dontSellTodayProfit = solve(prices, currentDay+1, false, dp);
            int max = Math.max(sellTodayProfit, dontSellTodayProfit);
            dp[currentDay][buyIndex] = max;
            return max;
        }

    }
}
