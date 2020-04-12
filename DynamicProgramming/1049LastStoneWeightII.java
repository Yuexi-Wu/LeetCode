/**
This question eaquals to partition an array into 2 subsets whose difference is minimal
(1) S1 + S2  = S
(2) S1 - S2 = diff  

==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2 


Now we should find the maximum of S2 , range from 0 to S / 2, using dp can solve this

dp[i][j]   = {true if some subset from 1st to j'th has a sum equal to sum i, false otherwise}
    i ranges from (sum of all elements) {1..n}
    j ranges from  {1..n}
*/
class Solution {
    public int lastStoneWeightII(int[] stones) {
        // dp
        // find the maximum subset sum s2
        int s = 0, s2 = 0;
        for (int stone : stones) {
            s += stone;
        }
        int n = stones.length;
        boolean[][] dp = new boolean[s+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= s/2; sum++) {
                if (dp[sum][i-1] || sum >= stones[i-1] && dp[sum-stones[i-1]][i-1]) {
                    dp[sum][i] = true;
                    s2 = Math.max(s2, sum);
                }
            }
        }
        return s - 2*s2;
    }
}
