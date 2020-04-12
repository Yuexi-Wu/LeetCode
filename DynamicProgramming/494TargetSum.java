class Solution {
    
    //DP
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || -S < -sum) {
            return 0;
        }
        // dp[i] : number of ways to reach possible sum i
        // i could be from -sum to sum, so dp length is 2*sum + 1
        // and dp[0] -- #of S = -sum dp[2*sum]-- #of S = sum
        // dp[sum] -- #of combine(0)
        // thus to find result, check dp[S+sum]
        int[] dp = new int[2*sum + 1];
        // base case :when we have no values to add/subtract, we have a sum of 0, and therefore there is only one way to arrive at S = 0.
        dp[sum] = 1;
        for (int num : nums) {
            int[] next = new int[2*sum + 1];
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 0) {
                    continue;
                }
                next[i+num] += dp[i];
                next[i-num] += dp[i];
            }
            dp = next;
        }
        return dp[S+sum];
    }
    
    
    
    
    //BF
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    
    private void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            calculate(nums, i+1, sum + nums[i], S);
            calculate(nums, i+1, sum - nums[i], S);
        }
    }
}
