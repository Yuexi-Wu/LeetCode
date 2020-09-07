### Selling stocks  
dp[n][k][0/1] -- this is day n, we had k transactions and 0 - we are not having the stock or 1 - we are keeping the stock  
  
state: 0, 1 -- 0 don't keep the stock, 1 keeping the stock  
maximam transaction times: k  
days: n  
  
The answer we want here is dp[n-1][k][0]  
  
`dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i])`  
 -- rest or sell  
`dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i])`  
 -- rest or buy  
   
 !!Important: Base cases  
 dp[-1][k][0] = 0  
 dp[-1][k][1] = MIN_VALUE  
 dp[i][0][0] = 0  
 dp[i][0][1] = MIN_VALUE  
   
 => `dp[0][k][0] = 0; dp[0][k][1] = -prices[0];`  
 => `dp[i][0][0] = 0; dp[i][0][1] = Integer.MIN_VALUE;`
 
