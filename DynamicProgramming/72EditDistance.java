class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n*m == 0) {
            return m+n;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    //the last character is same:
                    //1 + Math.min(dp[i-1][j], dp[i][j-1]): remove/add
                    //dp[i-1][j-1]: do nothing
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                } else {
                    //the last character is different:
                    //1 + Math.min(dp[i-1][j], dp[i][j-1]):remove/add
                    //dp[i-1][j-1]+1: replace
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return dp[n][m];
    }
}
