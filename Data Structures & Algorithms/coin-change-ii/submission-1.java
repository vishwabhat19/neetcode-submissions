class Solution {
    public int change(int amount, int[] coins) {
        Integer dp[][] = new Integer[coins.length][amount + 1];
       return solve(amount, coins, 0, dp); 
    }

    int solve(int amount, int[] coins, int i, Integer dp[][]) {

        if (i >= coins.length) return 0;

        if (amount == 0) return 1;

        if (dp[i][amount] != null) return dp[i][amount];

        if (amount < coins[i]) {
            dp[i][amount] = solve(amount, coins, i+1, dp);
            return dp[i][amount];

        }

        int take = solve(amount - coins[i], coins, i, dp);
        int dontTake = solve(amount, coins, i+1, dp);
        dp[i][amount] = take + dontTake;
        return dp[i][amount];
    }
}
