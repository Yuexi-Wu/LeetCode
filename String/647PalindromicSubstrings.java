class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        // total 2 * n - 1 numbers of centers
        //  1  1  1  1
        // a  b  c  b  d
        // 1  1  1  1  1
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}

// initial idea: too slow
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
