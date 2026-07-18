class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return solve(amount, coins, dp, 0);
    }

    int solve(int amount, int[] coins, Integer[][] dp, int i) {
        if (i >= coins.length) return 0;

        if (amount == 0) return 1;

        if (amount < coins[i]) {
            dp[i][amount] = solve(amount, coins, dp, i+1);
            return dp[i][amount];
        }

        if (dp[i][amount] != null) return dp[i][amount];

        int take = solve(amount - coins[i], coins, dp, i);

        int dontTake = solve(amount, coins, dp, i+1);

        dp[i][amount] = take + dontTake;

        return dp[i][amount];
    }
}
