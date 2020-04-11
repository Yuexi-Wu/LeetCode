class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int sIdx = 0, pIdx = 0;
        int star = -1, stmp = -1;
        while (sIdx < n) {
            if (pIdx < m && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?')) {
                pIdx++;
                sIdx++;
            } else if (pIdx < m && p.charAt(pIdx) == '*') {
                star = pIdx;
                stmp = sIdx;
                pIdx = star + 1;
            } else if (star == -1) {
                // if there is no * and no match
                return false;
            } else {
                //If pattern character != string character
                // or pattern is used up and there is * before,
                // move forward s index to match next char in p
                sIdx = stmp + 1;
                pIdx = star+1;
                stmp = sIdx;
            }
        }
        for (int i = pIdx; i < m; i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
