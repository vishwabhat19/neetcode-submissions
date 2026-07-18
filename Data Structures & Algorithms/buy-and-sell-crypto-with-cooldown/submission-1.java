class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) return 0;
        Integer dp[][] = new Integer[n][2];
        return solve(prices, 0, n, true, dp);
    }

    int solve(int[] prices, int currentDay, int n, boolean buyDay, Integer[][] dp) {
        if (currentDay >= n) return 0;

        int buyIndex = buyDay ? 1 : 0;

        if (dp[currentDay][buyIndex] != null) return dp[currentDay][buyIndex];

        int profit = 0;

        if (buyDay) {
            int buy = solve(prices, currentDay + 1, n, false, dp) - prices[currentDay];
            int dontBuy = solve(prices, currentDay + 1, n, true, dp);
            profit = Math.max(buy, profit);
            profit = Math.max(dontBuy, profit);
        }
        else {
            int sell = prices[currentDay] + solve(prices, currentDay + 2, n, true, dp);
            int dontSell = solve(prices, currentDay + 1, n, false, dp);
            profit = Math.max(sell, profit);
            profit = Math.max(profit, dontSell);
        }

        dp[currentDay][buyIndex] = profit;
        return profit;
    }
}
