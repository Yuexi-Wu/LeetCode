class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private boolean isPalindrome(String s) {
        if (s.equals("") || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int n = s.length();
        int left, right;
        if (n % 2 == 0) {
            left = n / 2 - 1;
            right = n / 2;
        } else {
            left = n / 2;
            right = n / 2;
        }
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
