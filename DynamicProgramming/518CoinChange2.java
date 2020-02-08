class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            //for each new coin we have a dp array to record upon current coins, how many ways to change. After calculating current coins's dp and continue with the next coin, we only need to add the old one with dp[currentAmount - currentcoin](the difference)
            for (int cur_amount = coin; cur_amount < amount + 1; cur_amount++) {
                dp[cur_amount] += dp[cur_amount - coin];
            }
        }
        return dp[amount];
    }
}
