class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0; dp[i][0][1] = Integer.MIN_VALUE;
            for (int k = 2; k >= 1; k--) {
                if (i == 0) {
                    dp[0][k][0] = 0; dp[0][k][1] = -prices[0];
                }
                if (i > 0) {
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }
            }
        }
        return dp[n-1][2][0];
    }
}
