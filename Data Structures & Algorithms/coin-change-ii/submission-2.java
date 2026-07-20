class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[amount + 1][coins.length + 1];
        return solve(amount, coins, 0, dp);
    }

    int solve(int amount, int[] coins, int i, Integer[][] dp) {
        if (amount == 0) return 1;

        if (i >= coins.length) return 0;

        if (dp[amount][i] != null) return dp[amount][i];

        if (amount >= coins[i]) {
            int take = solve(amount - coins[i], coins, i, dp);
            int dontTake = solve(amount, coins, i+1, dp);
            dp[amount][i] = take + dontTake;
            return (take + dontTake);
        }
        else {
            dp[amount][i] = solve(amount, coins, i+1, dp);
            return dp[amount][i];
        }

    }
}
