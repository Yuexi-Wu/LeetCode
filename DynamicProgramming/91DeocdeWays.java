class Solution {
    public int numDecodings(String s) { 
        if (s == null || s == "" || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len-1) == '0' ? 0 : 1;
        for (int i = len-2; i >= 0; i--) {
            //If there is consecutive zeros, return 0
            if (s.charAt(i) == '0' && s.charAt(i+1) == '0') {
                return 0;
            }
            
            String sub = s.substring(i, i+2);
            int num = Integer.parseInt(sub);
            
            if (num <= 26 && num >= 11 && num != 20) {
                dp[i] = dp[i+1] + dp[i+2];
            } else if (num == 10 || num == 20) {
                dp[i] = dp[i+2];
            } else if (s.charAt(i) > 2 && s.charAt(i+1) == '0') {
                return 0;
            } else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }
}

dp[i] = dp[i+1]+dp[i+2],     s.substring(i,i+2) == “11” ~ “26” && no 0

        dp[i-1],             s.substring(i,i+2) == larger than 26 && no 0

        dp[i-2],             s.substring(i,i+2) == “10”, “20”

        return 0,            s.substring(i,i+2) == “00”, “30” ~ “90”


Example:
index: 0 1 2 3 4 5
char[]:2 2 3 1 6
dp:    6 4 2 2 1 1

to calculate dp[0], either treat char[0] as independent character -- dp[i+1] ways, 
or treat char[0] and char[1] as one character -- dp[i+2] ways
[22,3,1,6]
[22,3,16]
dp[2] = 2↑
[2,2,3,1,6]
[2,2,3,16]
[2,23,1,6]
[2,23,16]
dp[1] = 4↑
