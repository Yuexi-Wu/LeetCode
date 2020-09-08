class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // dp[n][2]
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; dp[0][1] = - prices[0];
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            if (i >= 2) {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            }
            
        }
        return dp[n-1][0];
    }
}
