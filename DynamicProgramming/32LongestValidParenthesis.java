class Solution {
    public int longestValidParentheses(String s) {
         if (s.equals("") || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int ans = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) == '(') {
                dp[i] = 0;
            } else if (i > 1 && s.charAt(i-1) == ')' && s.charAt(i-2) == '(') {
                dp[i] = dp[i-2] + 2;
            } else if ((i - dp[i-1] - 2) >= 0 &&  s.charAt(i-1) == ')' && s.charAt(i-2) == ')') {
                if (s.charAt(i - dp[i-1] - 2) == '(') {
                    dp[i] = dp[i - dp[i-1] - 2] + dp[i-1] + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
