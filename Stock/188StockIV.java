class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[n][k][2]
        int n = prices.length;
        /**
        * If we don't consider this case, it will be Memory Limit Exceeded.
        */
        if (2 * k > n) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        int[][][] dp = new int[n][k+1][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                } else {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                }
                
            }
        }
        return dp[n-1][k][0];
    }
}
